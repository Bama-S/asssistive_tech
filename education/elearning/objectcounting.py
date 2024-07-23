import cv2
import imutils
import numpy as np
import matplotlib.pyplot as plt

inputimg = cv2.imread("img1.jpg")

#read the image and apply filter and threshold
    
image = inputimg
image_blur = cv2.medianBlur(image,25) 
image_blur_gray = cv2.cvtColor(image_blur, cv2.COLOR_BGR2GRAY)
image_res ,image_thresh = cv2.threshold(image_blur_gray,240,255,cv2.THRESH_BINARY_INV) #set values under 240 to be 1 and otherwise 0
kernel = np.ones((3,3),np.uint8)

opening = cv2.morphologyEx(image_thresh,cv2.MORPH_OPEN,kernel) 

dist_transform = cv2.distanceTransform(opening,cv2.DIST_L2,5) 
ret, last_image = cv2.threshold(dist_transform, 0.3*dist_transform.max(),255,0) 
last_image = np.uint8(last_image) 

cnts = cv2.findContours(last_image.copy(), cv2.RETR_EXTERNAL,cv2.CHAIN_APPROX_SIMPLE)
cnts = imutils.grab_contours(cnts) 

#count and draw circle using the contour points
for (i, c) in enumerate(cnts):
	((x, y), _) = cv2.minEnclosingCircle(c)
	cv2.drawContours(image, [c], -1, (0, 255, 0), 2) #connect the curve regions

print("total object count: ",len(cnts))

f, axs = plt.subplots(1,figsize=(12,5)) #display the image
axs.imshow(image,cmap="gray")