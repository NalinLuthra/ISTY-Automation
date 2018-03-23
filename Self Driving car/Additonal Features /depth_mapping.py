#!/usr/bin/env python

import numpy as np
import cv2 as cv

cap1 = cv.VideoCapture(0)
cap2 = cv.VideoCapture(1)


if __name__ == '__main__':
    while True :
        _, imgR = cap1.read()
        # add the delay in case of an error or, if only one camera is being read
        # cv.waitKey(1)
        _, imgL = cap2.read()

        imgR = cv.resize(imgR, (0,0), fx=0.5, fy=0.5)
        imgL = cv.resize(imgL, (0,0), fx=0.5, fy=0.5)
       
        window_size = 3
        min_disp = 16
        num_disp = 112-min_disp
        stereo = cv.StereoSGBM_create(
            minDisparity = min_disp,
            numDisparities = num_disp,
            blockSize = 1,
            P1 = 1*3*window_size**2,
            P2 = 5*3*window_size**2,
            disp12MaxDiff = 1,
            uniquenessRatio = 10,
            speckleWindowSize = 100,
            speckleRange = 32
        )# these para meters need to be tuned at the time of testing
        disp = stereo.compute(imgL, imgR).astype(np.float32) / 16.0
        cv.imshow('left', imgL)
        cv.imshow('right', imgR)
        cv.imshow('disparity', (disp-min_disp)/num_disp)

    cv.waitKey()
    cv.destroyAllWindows()
