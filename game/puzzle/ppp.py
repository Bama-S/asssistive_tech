import pygame, sys
import time
import random
from pygame.locals import *

pygame.init()

gameDisplay = pygame.display.set_mode((1000,700), pygame.FULLSCREEN)
display_width, display_height = gameDisplay.get_size()
print(display_width)
print(display_height)

pygame.display.set_caption('Pick n Match')

LEFT = 1
RIGHT = 3

count = 0
score = 0

white = (255,255,255)
black = (0,0,0)
red = (200,0,0)
light_red = (255,0,0)
green = (34, 177, 76)
light_green = (0, 255, 0)
yellow = (200,200,0)
light_yellow = (255,255,0)
blue = (53, 115, 255)

clock = pygame.time.Clock()

seconds = 1

selectspeed = pygame.mixer.Sound('audio/selectspeed.wav')
setspeed = pygame.mixer.Sound('audio/setspeed.wav')
welcome = pygame.mixer.Sound('audio/welcome.wav')
objective = pygame.mixer.Sound('audio/objective.wav')
gplay = pygame.mixer.Sound('audio/play.wav')
levels = pygame.mixer.Sound('audio/levels.wav')
cmatching = pygame.mixer.Sound('audio/cmatching.wav')
omatching = pygame.mixer.Sound('audio/omatching.wav')
rracey = pygame.mixer.Sound('audio/racey.wav')
gquit = pygame.mixer.Sound('audio/quit.wav')

smallfont = pygame.font.SysFont("comicsansms", 25)
medfont = pygame.font.SysFont("comicsansms", 50)
largefont = pygame.font.SysFont("comicsansms", 85)

carImg = pygame.image.load('racecar.png')
roadImg = pygame.image.load('road.png')
car_width = 68
block_color = (53, 115, 255)

pbgrey = pygame.image.load('rectangles/bgrey.png')
pblue = pygame.image.load('rectangles/blue.png')
pbrown = pygame.image.load('rectangles/brown.png')
pgreen = pygame.image.load('rectangles/green.png')
pdgreen = pygame.image.load('rectangles/dgreen.png')
pyellow = pygame.image.load('rectangles/yellow.png')
pdyellow = pygame.image.load('rectangles/dyellow.png')
pgrey = pygame.image.load('rectangles/grey.png')
plavender = pygame.image.load('rectangles/lavender.png')
plgrey = pygame.image.load('rectangles/lgrey.png')
plime = pygame.image.load('rectangles/lime.png')
pmaroon = pygame.image.load('rectangles/maroon.png')
porange = pygame.image.load('rectangles/orange.png')
ppink = pygame.image.load('rectangles/pink.png')
pred = pygame.image.load('rectangles/red.png')
psblue = pygame.image.load('rectangles/sblue.png')
psky = pygame.image.load('rectangles/sky.png')
ptuquiose = pygame.image.load('rectangles/tuquiose.png')
pviolet = pygame.image.load('rectangles/violet.png')
pwhite = pygame.image.load('rectangles/white.png')

oballoon = pygame.image.load('objects/balloon.png')
oballoon1 = pygame.image.load('objects/balloon1.png')
oballons = pygame.image.load('objects/ballons.png')
oballons1 = pygame.image.load('objects/ballons1.png')
obasketball = pygame.image.load('objects/basketball.png')
obasketball1 = pygame.image.load('objects/basketball1.png')
obird = pygame.image.load('objects/bird.png')
obird1 = pygame.image.load('objects/bird1.png')
obook = pygame.image.load('objects/book.png')
obook1 = pygame.image.load('objects/book.png')
ocar = pygame.image.load('objects/car.png')
ocar1 = pygame.image.load('objects/car1.png')
oelephant = pygame.image.load('objects/elephant.png')
oelephant1 = pygame.image.load('objects/elephant1.png')
ofish = pygame.image.load('objects/fish.png')
ofish1 = pygame.image.load('objects/fish1.png')
ofootball = pygame.image.load('objects/football.png')
ofootball1 = pygame.image.load('objects/football1.png')
ofruits = pygame.image.load('objects/fruits.png')
ofruits1 = pygame.image.load('objects/fruits1.png')
ohorse = pygame.image.load('objects/horse.png')
ohorse1 = pygame.image.load('objects/horse1.png')
ohouse = pygame.image.load('objects/house.png')
ohouse1 = pygame.image.load('objects/house1.png')
oice = pygame.image.load('objects/icecream.png')
oice1 = pygame.image.load('objects/icecream1.png')
omango = pygame.image.load('objects/mango.png')
omango1 = pygame.image.load('objects/mango1.png')
oorange = pygame.image.load('objects/orange.png')
oorange1 = pygame.image.load('objects/orange1.png')
otennis = pygame.image.load('objects/tennis.png')
otennis1 = pygame.image.load('objects/tennis1.png')
otiger = pygame.image.load('objects/tiger.png')
otiger1 = pygame.image.load('objects/tiger1.png')
otree = pygame.image.load('objects/tree.png')
otree1 = pygame.image.load('objects/tree1.png')
ozebra = pygame.image.load('objects/zebra.png')
ozebra1 = pygame.image.load('objects/zebra1.png')

dictRect = {'bgrey':pbgrey, 'blue':pblue, 'brown':pbrown, 'green':pgreen, 'dgreen':pdgreen, 'yellow':pyellow, 'dyellow':pdyellow, 'grey':pgrey, 'lavender':plavender, 'lgrey':plgrey, 'lime':plime, 'maroon':pmaroon, 'orange':porange, 'pink':ppink, 'red':pred, 'sblue':psblue, 'sky':psky, 'tuquiose':ptuquiose, 'violet':pviolet, 'white':pwhite}
sortedRect = sorted(dictRect)
print(sortedRect)

dictObj = {'balloon':oballoon, 'ballons':oballons, 'basketball':obasketball, 'bird':obird, 'book':obook, 'car':ocar, 'elephant':oelephant, 'fish':ofish, 'football':ofootball, 'fruits':ofruits, 'horse':ohorse, 'house':ohouse, 'ice':oice, 'mango':omango, 'orange':oorange, 'tennis':otennis, 'tiger':otiger, 'tree':otree, 'zebra':ozebra}
dictTargetObj = {'balloon':oballoon1, 'ballons':oballons1, 'basketball':obasketball1, 'bird':obird1, 'book':obook1, 'car':ocar1, 'elephant':oelephant1, 'fish':ofish1, 'football':ofootball1, 'fruits':ofruits1, 'horse':ohorse1, 'house':ohouse1, 'ice':oice1, 'mango':omango1, 'orange':oorange1, 'tennis':otennis1, 'tiger':otiger1, 'tree':otree1, 'zebra':ozebra1}
sortedObj = sorted(dictObj)
print(sortedObj)

sortedAll = []
sortedAll.extend(sortedRect)
sortedAll.extend(sortedObj)
print(sortedAll)

f = open("months.txt")
next = f.readline().strip()
x = []
while next != "":
    x.append(next)
    next = f.readline().strip()
    
def gameScore(score):
    font = pygame.font.SysFont(None, 50)
    text = font.render("Score: "+str(score), True, blue)
    gameDisplay.blit(text, (0, 0))
    
def text_to_button(msg, color, buttonx, buttony, buttonwidth, buttonheight, size = "small"):
    textSurf, textRect = text_objects(msg,color,size)
    textRect.center = ((buttonx+(buttonwidth/2)), buttony+(buttonheight/2))
    gameDisplay.blit(textSurf, textRect)

def text_objects(text, color, size = "small"):
    if size == "small":
        textSurface = smallfont.render(text, True, color)
    if size == "medium":
        textSurface = medfont.render(text, True, color)
    if size == "large":
        textSurface = largefont.render(text, True, color)
    return textSurface, textSurface.get_rect()

def message_to_screen(msg, color, y_displace=0, size = "small"):
    textSurf, textRect = text_objects(msg,color,size)
    textRect.center = (int(display_width/2), int(display_height/2)+y_displace)
    gameDisplay.blit(textSurf, textRect)
     
def button(text, x, y, width, height, inactive_color, active_color, action = None):
    cur = pygame.mouse.get_pos()
    click = pygame.mouse.get_pressed()
    #print(click)
    if x + width> cur[0] > x and y + height > cur[1] > y:
        pygame.draw.rect(gameDisplay, active_color, (x,y,width,height))
        if click[0] == 1 and action != None:
            if action == "quit":
                pygame.quit()
                quit()

            if action == "controls":
                game_controls()

            if action == "play":
                objectMatching()

            if action == "main":
                game_intro(seconds)
            
    else:
        pygame.draw.rect(gameDisplay, inactive_color, (x,y,width,height))
    text_to_button(text, black, x, y, width, height)
    
def things(thingx, thingy, thingw, thingh, color):
    pygame.draw.rect(gameDisplay, color , [thingx, thingy, thingw, thingh])

def pause():
    paused = True
    gameDisplay.fill(black)
    message_to_screen("Game Over", red, -100, size = "large")
    message_to_screen("Press R to Replay or Q to Quit", blue, 25)
    pygame.display.update()
    while paused:
        for event in pygame.event.get():
            
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_r:
                    #paused == False
                    gameLoop()
                elif event.key == K_ESCAPE:
                    pygame.quit()
                    sys.exit(0)

                elif event.key == pygame.K_q:
                    pygame.quit()
                    quit()

        clock.tick(5)
    
def main():

    selectspeed.play()
    time.sleep(2)
    clock = pygame.time.Clock()
    FPS = 30
    global seconds
    pygame.time.set_timer(USEREVENT + 1, 2000)
    
    while True:
        clock.tick(FPS)
        gameDisplay.fill(black)
        seconds_display = smallfont.render("Click to select Scan Speed: " + str(seconds), 1, white)
        gameDisplay.blit(seconds_display, (450, (display_height/2)))
        for event in pygame.event.get():
            if event.type == QUIT:
                quit()
            elif event.type == pygame.MOUSEBUTTONDOWN:
                if event.button == RIGHT:
                    pygame.quit()
                    sys.exit(0)
                elif event.button == LEFT:
                    setspeed.play()
                    time.sleep(2)
                    game_intro(seconds)
            elif event.type == USEREVENT + 1:
                seconds+=1
        pygame.display.flip()

def game_controls():
    gcont = True

    thing_startx = 390
    thing_starty = 50
    thing_speed = 100
    thing_width = 10
    thing_height = 50

    pygame.time.set_timer(USEREVENT + 1, seconds*1000)
    
    while gcont:
        gameDisplay.fill(black)

        things(thing_startx, thing_starty, thing_width, thing_height, blue)

        button("Play", 400,50,200,50, green, light_green, action = "play")
        button("Color Matching", 400,150,200,50, yellow, light_yellow, action = "main")
        button("Object Matching", 400,250,200,50, yellow, light_yellow, action = "main")
        button("Racey", 400,350,200,50, yellow, light_yellow, action = "main")
        button("Arrange Statement", 400,450,200,50, yellow, light_yellow, action = "main")
        button("Quit", 400,550,200,50, red, light_red, action = "quit")

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()

            elif event.type == USEREVENT + 1:
                thing_starty += thing_speed
                if thing_starty == 50:
                    gplay.play()

                elif thing_starty == 150:
                    cmatching.play()
                        
                elif thing_starty == 250:
                    omatching.play()

                elif thing_starty == 350:
                    rracey.play()

                elif thing_starty == 450:
                    pass

                elif thing_starty == 550:
                    gquit.play()
                    
                elif thing_starty > 550:
                    thing_starty = 50

            if event.type == pygame.MOUSEBUTTONDOWN:
                if event.button == LEFT:
                    if thing_starty == 50:
                        gameLoop(thing_starty)

                    elif thing_starty == 150:
                        gameLoop(thing_starty)
                        
                    elif thing_starty == 250:
                        gameLoop(thing_starty)

                    elif thing_starty == 350:
                        gameLoop(thing_starty)

                    elif thing_starty == 450:
                        gameLoop(thing_starty)

                    elif thing_starty == 550:
                        pygame.quit()
                        quit()
                        
                elif event.button == RIGHT:
                    pygame.quit()
                    sys.exit(0)


        pygame.display.update()

        clock.tick(5)

def replay(scan_speed, rcount):
    intro = True

    global score
    score = 0
    
    thing_startx = 300
    thing_starty = 400
    thing_speed = 300
    thing_width = 10
    thing_height = 50

    pygame.time.set_timer(USEREVENT + 1, scan_speed*1000)
    
    while intro:

        gameDisplay.fill(black)
        
        things(thing_startx, thing_starty, thing_width, thing_height, blue)

        button("Replay", 200,400,100,50, green, light_green, action = "play")
        button("Home", 500,400,100,50, yellow, light_yellow, action = "controls")
        button("Quit", 800,400,100,50, red, light_red, action = "quit")
    
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()

            elif event.type == USEREVENT + 1:
                thing_startx += thing_speed
                if thing_startx > 900:
                    thing_startx = 300

            if event.type == pygame.MOUSEBUTTONDOWN:
                if event.button == LEFT:
                    if thing_startx == 300:
                        count = 0
                        score = 0
                        if rcount == 0:
                            mainGame()
                        elif rcount == 1:
                            colorMatching()
                        elif rcount == 2:
                            objectMatching()
                        elif rcount == 4:
                            racey()

                    elif thing_startx == 600:
                        game_intro(scan_speed)
                        
                    elif thing_startx == 900:
                        pygame.quit()
                        quit()

                elif event.button == RIGHT:
                    pygame.quit()
                    sys.exit(0)

            
        pygame.display.update()

        clock.tick(15)


def game_intro(scan_speed):
##    welcome.play()
    intro = True

    global score
    score = 0
    
    thing_startx = 300
    thing_starty = 500
    thing_speed = 300
    thing_width = 10
    thing_height = 50

    pygame.time.set_timer(USEREVENT + 1, scan_speed*1000)
    
    while intro:

        gameDisplay.fill(black)
        message_to_screen("Pick 'n' Match", green, -100, size = "large")
        message_to_screen("The objective is to pick object and match the identicals", white, -30)
##        message_to_screen("hello", blue, 10)
##        message_to_screen("hello", blue, 50)
        
        things(thing_startx, thing_starty, thing_width, thing_height, blue)

        button("play", 200,500,100,50, green, light_green, action = "play")
        button("level", 500,500,100,50, yellow, light_yellow, action = "controls")
        button("quit", 800,500,100,50, red, light_red, action = "quit")
    
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()

            elif event.type == USEREVENT + 1:
                thing_startx += thing_speed
                if thing_startx == 300:
                    gplay.play()

                elif thing_startx == 600:
                    levels.play()

                elif thing_startx == 900:
                    gquit.play()
                    
                elif thing_startx > 900:
                    thing_startx = 300

            if event.type == pygame.MOUSEBUTTONDOWN:
                if event.button == LEFT:
                    if thing_startx == 300:
                        count = 0
                        score = 0
                        mainGame()

                    elif thing_startx == 600:
                        game_controls()
                        
                    elif thing_startx == 900:
                        pygame.quit()
                        quit()

                elif event.button == RIGHT:
                    pygame.quit()
                    sys.exit(0)

            
        pygame.display.update()

        clock.tick(15)

def gameLoop(thing_starty):
    global score
    global count
    if thing_starty == 50:
        count = 0
        score = 0
        mainGame()
    elif thing_starty == 150:
        count = 0
        score = 0
        colorMatching()
    elif thing_starty == 250:
        count = 0
        score = 0
        objectMatching()
    elif thing_starty == 350:
        count = 0
        score = 0
        racey()
    elif thing_starty == 450:
        count = 0
        score = 0
        statement_arrangement()

def scored(flag, rcount):
    message_display('Correct Choice', flag, rcount)
    
def failed(flag, rcount):
    message_display('Wrong Choice', flag, rcount)
    
def message_display(text, flag, rcount):
    gameDisplay.fill(black)
    TextSurf, TextRect = text_objects(text, white, "large")
    TextRect.center = ((display_width/2), (display_height/2))
    gameDisplay.blit(TextSurf, TextRect)
    pygame.display.update();

    time.sleep(2)
    if flag == 0:
        mainGame()
    elif flag == 1:
        colorMatching()
    elif flag == 2:
        objectMatching()
    elif flag == 3:
        game_intro(seconds)
    elif flag == 4:
        statement_arrangement()

def mainGame():
    global count
    global score
    rcount = 0
    if count>10:
        flag = 3
        message_display('Final Score: '+str(score), flag, rcount)
    else:
        print('mainGame called')
        count=count+1
        flag = 0
        clock = pygame.time.Clock()
        pygame.time.set_timer(USEREVENT + 1, seconds*1000)
        z = dictRect.copy()
        z.update(dictObj)
        sortedRect = sorted(dictRect)
        sortedObj = sorted(dictObj)
        sortedAll = []
        sortedAll.extend(sortedRect)
        sortedAll.extend(sortedObj)
        tempList = sortedAll
        x = []
        target = tempList.pop(tempList.index(random.choice(tempList)))
        if target in dictRect.keys():
            x.append(dictRect[target])
        else:
            x.append(dictObj[target])
        a = tempList.pop(tempList.index(random.choice(tempList)))
        if a in dictRect.keys():
            x.append(dictRect[a])
        else:
            x.append(dictObj[a])
        b = tempList.pop(tempList.index(random.choice(tempList)))
        del tempList[:]
        print(tempList)
        if b in dictRect.keys():
            x.append(dictRect[b])
        else:
            x.append(dictObj[b])

        option1 = x.pop(x.index(random.choice(x)))
        option2 = x.pop(x.index(random.choice(x)))
        option3 = x.pop(x.index(random.choice(x)))

        print(option1)
        thing_startx = 25
        thing_starty = 655
        thing_speed = 350
        thing_width = 250
        thing_height = 50

        gameExit = False

        while not gameExit:
            gameDisplay.fill(black)

            things(thing_startx, thing_starty, thing_width, thing_height, blue)
            gameScore(score)

    ##        message_to_screen(hwhite)
    ##        message_to_screen(hblue)
    ##        message_to_screen(hgreen)
    ##        message_to_screen(hhwhite)

            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    quit()

                elif event.type == USEREVENT + 1:
                    thing_startx += thing_speed
                    if thing_startx > 725:
                        thing_startx = 25

                if event.type == pygame.MOUSEBUTTONDOWN:
                    if event.button == RIGHT:
                        game_intro(seconds)
                        
                    elif event.button == LEFT:
                        if thing_startx == 25:
                            if option1 == z[target]:
                                score+=1
                                scored(flag, rcount)
                            else:
                                failed(flag, rcount)

                        elif thing_startx == 375:
                            if option2 == z[target]:
                                score+=1
                                scored(flag, rcount)
                            else:
                                failed(flag, rcount)

                        elif thing_startx == 725:
                            if option3 == z[target]:
                                score+=1
                                scored(flag, rcount)
                            else:
                                failed(flag, rcount)

            gameDisplay.blit(option1, (25, 400))
            gameDisplay.blit(option2, (375, 400))
            gameDisplay.blit(option3, (725, 400))
            if target in dictRect.keys():
                gameDisplay.blit(dictRect[target], (375, 10))
            else:
                gameDisplay.blit(dictTargetObj[target], (375, 10))

            pygame.display.update()

            clock.tick(15)
    
def colorMatching():
    global count
    global score
    flag = 1
    rcount = 1
    if count>3:
        flag = 3
        message_display('Final Score: '+str(score), flag, rcount)
    else:
        print('colorMatching called')
        count=count+1
        flag = 1
        clock = pygame.time.Clock()
        pygame.time.set_timer(USEREVENT + 1, seconds*1000)
        sortedRect = sorted(dictRect)
        tempList = sortedRect
        x = []
        target = tempList.pop(tempList.index(random.choice(tempList)))
        x.append(dictRect[target])
        a = tempList.pop(tempList.index(random.choice(tempList)))
        x.append(dictRect[a])
        b = tempList.pop(tempList.index(random.choice(tempList)))
        del tempList[:]
        print(tempList)
        x.append(dictRect[b])

        option1 = x.pop(x.index(random.choice(x)))
        option2 = x.pop(x.index(random.choice(x)))
        option3 = x.pop(x.index(random.choice(x)))

        thing_startx = 25
        thing_starty = 655
        thing_speed = 350
        thing_width = 250
        thing_height = 50

        gameExit = False

        while not gameExit:
            gameDisplay.fill(black)

            things(thing_startx, thing_starty, thing_width, thing_height, blue)
            gameScore(score)
            
    ##        message_to_screen(hwhite)
    ##        message_to_screen(hblue)
    ##        message_to_screen(hgreen)
    ##        message_to_screen(hhwhite)

            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    quit()

                elif event.type == USEREVENT + 1:
                    thing_startx += thing_speed
                    if thing_startx > 725:
                        thing_startx = 25

                if event.type == pygame.MOUSEBUTTONDOWN:
                    if event.button == RIGHT:
                        game_intro(seconds)
                        
                    elif event.button == LEFT:
                        if thing_startx == 25:
                            if option1 == dictRect[target]:
                                score+=1
                                scored(flag, rcount)
                            else:
                                failed(flag, rcount)

                        elif thing_startx == 375:
                            if option2 == dictRect[target]:
                                score+=1
                                scored(flag, rcount)
                            else:
                                failed(flag, rcount)

                        elif thing_startx == 725:
                            if option3 == dictRect[target]:
                                score+=1
                                scored(flag, rcount)
                            else:
                                failed(flag, rcount)

            gameDisplay.blit(option1, (25, 400))
            gameDisplay.blit(option2, (375, 400))
            gameDisplay.blit(option3, (725, 400))
            gameDisplay.blit(dictRect[target], (375, 10))

            pygame.display.update()

            clock.tick(15)
    
def objectMatching():
    global count
    global score
    flag = 2
    rcount = 2
    if count>3:
        flag = 3
        message_display('Final Score: '+str(score), flag, rcount)
    else:
        print('objectMatching called')
        count=count+1
        flag = 2
        clock = pygame.time.Clock()
        pygame.time.set_timer(USEREVENT + 1, seconds*1000)
        sortedObj = sorted(dictObj)
        tempList = sortedObj
        x = []
        target = tempList.pop(tempList.index(random.choice(tempList)))
        x.append(dictObj[target])
        a = tempList.pop(tempList.index(random.choice(tempList)))
        x.append(dictObj[a])
        b = tempList.pop(tempList.index(random.choice(tempList)))
        del tempList[:]
        print(tempList)
        x.append(dictObj[b])

        option1 = x.pop(x.index(random.choice(x)))
        option2 = x.pop(x.index(random.choice(x)))
        option3 = x.pop(x.index(random.choice(x)))

        thing_startx = 25
        thing_starty = 655
        thing_speed = 350
        thing_width = 250
        thing_height = 50

        gameExit = False

        while not gameExit:
            gameDisplay.fill(black)

            things(thing_startx, thing_starty, thing_width, thing_height, blue)
            gameScore(score)

    ##        message_to_screen(hwhite)
    ##        message_to_screen(hblue)
    ##        message_to_screen(hgreen)
    ##        message_to_screen(hhwhite)

            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    quit()

                elif event.type == USEREVENT + 1:
                    thing_startx += thing_speed
                    if thing_startx > 725:
                        thing_startx = 25

                if event.type == pygame.MOUSEBUTTONDOWN:
                    if event.button == RIGHT:
                        game_intro(seconds)
                        
                    elif event.button == LEFT:
                        if thing_startx == 25:
                            if option1 == dictObj[target]:
                                score+=1
                                scored(flag, rcount)
                            else:
                                failed(flag, rcount)

                        elif thing_startx == 375:
                            if option2 == dictObj[target]:
                                score+=1
                                scored(flag, rcount)
                            else:
                                failed(flag, rcount)

                        elif thing_startx == 725:
                            if option3 == dictObj[target]:
                                score+=1
                                scored(flag, rcount)
                            else:
                                failed(flag, rcount)

            gameDisplay.blit(option1, (25, 400))
            gameDisplay.blit(option2, (375, 400))
            gameDisplay.blit(option3, (725, 400))
            gameDisplay.blit(dictTargetObj[target], (375, 10))

            pygame.display.update()

            clock.tick(15)

def car(x,y):
    gameDisplay.blit(carImg, (x,y))
    
def raceyThings(thingx, thingy, thingw, thingh, color):
    pygame.draw.rect(gameDisplay, block_color , [thingx, thingy, thingw, thingh])

def crash(rcount):
    largeText = pygame.font.Font('freesansbold.ttf',115)
    TextSurf, TextRect = text_objects('You Crashed', blue, "large")
    TextRect.center = ((display_width/2), (display_height/2))
    gameDisplay.blit(TextSurf, TextRect)
    pygame.display.update();

    time.sleep(2)

    replay(seconds, rcount)


def racey():
    global count
    global score
    
    x = 410
    y = (display_height * 0.75)

    x_change = 0
    thing_startx = random.choice((405, 515))
    thing_starty = -300
    thing_speed = 3
    thing_width = 80
    thing_height = 100

    rcount = 4

    gameExit = False

    while not gameExit:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()

            if event.type == pygame.MOUSEBUTTONDOWN:
                if x == 410:
                    x = 515
                elif x == 515:
                    x = 410

        gameDisplay.fill(black)
        gameDisplay.blit(roadImg, (400,0))
        raceyThings(thing_startx, thing_starty, thing_width, thing_height, block_color)
        thing_starty += thing_speed
        car(x,y)
        
        gameScore(score)

        if thing_starty > display_height:
            thing_starty = 0 - thing_height
            thing_startx = random.choice((405, 515))
            score += 1
            thing_speed += 0.2

        if y < thing_starty+thing_height:
            if x > thing_startx and x < thing_startx+thing_width or x+car_width > thing_startx and x + car_width < thing_startx+thing_width:
                crash(rcount)
                
        pygame.display.update()

def statement_arrangement():
    global score
    rcount = 0
    clock = pygame.time.Clock()
    pygame.time.set_timer(USEREVENT + 1, seconds*1000)
    statement = random.choice(x)
    words = statement.split()
    random.shuffle(words)
##    print(words)
##    print(len(words))
    wlength = len(words)
    tstatement = ''
    flag = 4
    marker_position = 0
    thing_startx = 0
    thing_starty = display_height/2
    thing_width = 150
    thing_height = 50
    marker_startx = 100
    gameExit = False

    while not gameExit:
        thing_startx = 100
        
        wlength = len(words)
##        print(wlength)
        gameDisplay.fill(black)
        message_to_screen(statement, white, -300)
        tstatement = tstatement.strip()
        message_to_screen(tstatement, white, 200)
        if((len(tstatement.split())) == (len(statement.split()))):
            if(tstatement == statement):
                score+=1
                scored(flag, rcount)
            else:
                failed(flag, rcount)
                
##        while wlength:
##            things(thing_startx, thing_starty, thing_width, thing_height, black)
##            text_to_thing(words[wlength-1],white,thing_startx,thing_starty,thing_width,thing_height)
##            thing_startx+=thing_width
##            wlength-=1
        things(marker_startx, thing_starty+thing_height, thing_width, thing_height, blue)
        gameScore(score)
        for event in pygame.event.get():        
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()

            elif event.type == USEREVENT + 1:
                print(marker_position)
                marker_position += 1
                marker_startx += thing_width
                if marker_startx > (thing_width*wlength):
                    marker_startx = 100
                    marker_position = 0

            if event.type == pygame.MOUSEBUTTONDOWN:
                tstatement += ' '
                tstatement += words[((wlength-1) - marker_position)]

        while wlength:
            things(thing_startx, thing_starty, thing_width, thing_height, black)
            text_to_button(words[wlength-1],white,thing_startx,thing_starty,thing_width,thing_height)
            thing_startx+=thing_width
            wlength-=1    
        pygame.display.update()

        clock.tick(15)

main()
game_intro()
gameLoop()

pygame.quit()
quit()
 
