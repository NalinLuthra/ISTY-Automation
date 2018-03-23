import cv2
from detedtor import draw_detections, inside

hand_cascade = cv2.CascadeClassifier('/home/kshitij/PycharmProjects/Hand_Rec/haarcascade_frontalcatface.xml')
hog = cv2.HOGDescriptor()
hog.setSVMDetector(cv2.HOGDescriptor_getDefaultPeopleDetector())

cap = cv2.VideoCapture(0)

while True:
    _, img = cap.read()
    # human detection
    found, w = hog.detectMultiScale(img, winStride=(8, 8), padding=(32, 32), scale=1.05)
    found_filtered = []
    for ri, r in enumerate(found):
        for qi, q in enumerate(found):
            if ri != qi and inside(r, q):
                break
        else:
            found_filtered.append(r)
    draw_detections(img, found)
    draw_detections(img, found_filtered, 3)
    print('%d (%d) found' % (len(found_filtered), len(found)))
    #cv2.imshow('Human', img)
    #resizing to make it faster
    #img = cv2.resize(img, (320, 240), interpolation=cv2.INTER_LINEAR)
    # face detection
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    hands = hand_cascade.detectMultiScale(gray,3,5)
    for (x, y, w, h) in hands:
        cv2.rectangle(img, (x, y), (x + w, y + h), (255, 255, 255), 2)
    cv2.imshow('Human/Face', img)
    cv2.waitKey(1) # delay given so that the camera feed works properly ... try if removal is possible
