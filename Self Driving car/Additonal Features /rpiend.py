import serial
ser=serial.serial('/dev/ttyACM0', 9600)
#/dev/ttyAMC0 is an example of the port.
flag=1
while flag:
	n=input('Input instruction: ')
	string=str(n)
	if string == "x"
		flag=0
	ser.write(string)
	print string
