from firebase import firebase
import sys
import time, datetime
import threading
import GPIO.RPi as GPIO
from sys import argv



available_GPIO=['4','5','6','12','13','16','17','18','22','23','24','25','26','27','']

pin_to_device={}

GPIO.setmode(GPIO.BCM)

GPIO.setup(18,GPIO.OUT)
time_delay=int(argv[1])
url="https://istyyyyy-76788.firebaseio.com/"
firebase=firebase.FirebaseApplication(url)
url_user_id='/jZkCwRgRCqcO2Zcu4s94Gtl4Uv82'
#jZkCwRgRCqcO2Zcu4s94Gtl4Uv82


#url="https://istyyyyy-76788.firebaseio.com/istyyyyy-76788"+input("enter user id : \n")


def instantaneous_db_state():

    res=firebase.get(url_user_id,None)
    i=0
    for key in res:
        pin_to_device[key]=available_GPIO[i]
        i=+1
        if res[key]['status']=='ON':
            print("STATUS : ON : ",res[key],"\n")
            GPIO.output(pin_to_device[key],GPIO.HIGH)
            #code to turn em on
        if res[key]['status']=='OFF':
            print("STATUS : OFF : ",res[key],"\n")
            GPIO.output(pin_to_device[key],GPIO.LOW)
            #code to turn em off
        
        
        print("\n")

def scheduled_db_state():
    res=firebase.get(url_user_id,None)

    for key in res:
        if res[key]['schedule']=='NONE' or res[key]['schedule']=='null   to  null' or res[key]['schedule']=='Schedule':
            pass
        else:
            if float(res[key]['schedule'])<time.time():
                print("CODE TO TURN IT ON/OFF")
            else:
                pass


def create_device_list():
    res=firebase.get(url_user_id,None)
    i=0
    for key in res:
        pin_to_device[key]=available_GPIO[i]
        i=i+1
    
        
def start_job(time_delay):
    create_device_list()
    print(pin_to_device)

    while True:
        time.sleep(time_delay)
        instantaneous_db_state()
        scheduled_db_state()
    

start_job(time_delay)

