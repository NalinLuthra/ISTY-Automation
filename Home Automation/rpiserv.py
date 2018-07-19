from firebase import firebase
import sys
import time, datetime
import threading

from sys import argv

time_delay=int(argv[1])
url="https://istyyyyy-76788.firebaseio.com/"
firebase=firebase.FirebaseApplication(url)
url_user_id='/jZkCwRgRCqcO2Zcu4s94Gtl4Uv82'
#jZkCwRgRCqcO2Zcu4s94Gtl4Uv82



#url="https://istyyyyy-76788.firebaseio.com/istyyyyy-76788"+input("enter user id : \n")


def instantaneous_db_state():

    res=firebase.get(url_user_id,None)

    for key in res:
        if res[key]['status']=='ON':
            print("STATUS : ON : ",res[key],"\n")
            #code to turn em on
        if res[key]['status']=='OFF':
            print("STATUS : OFF : ",res[key],"\n")
            #code to turn em off
        
        
        print("\n")

def scheduled_db_state():
    res=firebase.get(url_user_id,None)

    for key in res:
        if res[key]['schedule']=='NONE':
            pass
        else:
            if float(res[key]['schedule'])<time.time():
                print("CODE TO TURN IT ON/OFF")
            else:
                pass
        




def start_job(time_delay):
    while True:
        time.sleep(time_delay)
        instantaneous_db_state()
        scheduled_db_state()
    


start_job(time_delay)

