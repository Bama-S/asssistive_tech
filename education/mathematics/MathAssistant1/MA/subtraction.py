import wx

class subtraction(wx.Frame):
    def __init__(self,parent,id,title,nm1,nm2,fntsz,mnuspeed):
        wx.Frame.__init__(self,parent,id,title)
        #Menu Initialisation Starts..
        self.fontsize=fntsz
        self.speed=mnuspeed
        self.MainPanel=wx.Panel(self,-1)#Main Panel Contains .. MenuPanel+WorksheetPanel
        
        self.butList=range(15) #List of buttons...
        self.ButtonIndex=-1 #Index Points to Current Active Button..
        self.MenuTimer=wx.Timer(self)
        self.Group=0
        self.Mx1,self.My1=0,0
        self.wdt,self.ht=0,0
        self.MenuPanel=wx.Panel(self.MainPanel,-1) #Menu Panel
        self.Bind(wx.EVT_TIMER,self.ChangeButCur)
        self.MenuPanel.Bind(wx.EVT_PAINT,self.OnMenuPaint)
        font=wx.SystemSettings_GetFont(wx.SYS_DEFAULT_GUI_FONT)
        font.SetPointSize(self.fontsize)
        font.SetWeight(wx.FONTWEIGHT_BOLD)
        font.SetFamily(wx.FONTFAMILY_DECORATIVE)
        self.font=font
        menuBox1=wx.BoxSizer(wx.HORIZONTAL)
        menuBox2=wx.BoxSizer(wx.HORIZONTAL)
        vMenuBox=wx.BoxSizer(wx.VERTICAL)
        for i in range(10):
            self.butList[i]=wx.Button(self.MenuPanel,i,str(i))
            self.butList[i].SetFont(font)
            self.butList[i].Bind(wx.EVT_BUTTON,self.OnButtonClick)
            menuBox1.Add(self.butList[i],0,wx.ALL,5)
        for i in range(10,15):
            self.butList[i]=wx.Button(self.MenuPanel,i,'')
            self.butList[i].SetFont(font)
            self.butList[i].Bind(wx.EVT_BUTTON,self.OnButtonClick)
            menuBox2.Add(self.butList[i],0,wx.ALL,5)
        self.butList[10].SetLabel("-->")
        self.butList[11].SetLabel("<--")
        self.butList[12].SetLabel("GotoBorrow")
        self.butList[13].SetLabel("Evaluate")
        self.butList[14].SetLabel("Exit")
        vMenuBox.Add(menuBox1,0,wx.ALL,5)
        vMenuBox.Add(menuBox2,0,wx.ALL,5)
        self.MenuPanel.SetSizer(vMenuBox)
        
        #Menu Initialisation Ends...
        
        #Worksheet Initialisation Starts...
        
        self.WorkSheetPanel=wx.Panel(self.MainPanel,-1) # Worksheet panel
        x,y=300,100
        self.pic=wx.StaticBitmap(self.WorkSheetPanel,-1,wx.Bitmap('files/default.png'),pos=(600,200))
        self.maxsz=len(str(nm1))
        self.carry=range(self.maxsz)
        font1=wx.FFont(self.fontsize,wx.FONTFAMILY_DECORATIVE)
        borrow_font=wx.FFont(self.fontsize-10,wx.FONTFAMILY_MODERN)
        self.num1=range(self.maxsz)
        self.strike=range(self.maxsz)
        self.num2=wx.StaticText(self.WorkSheetPanel,-1,'0',(x,y+50*2))
        self.num2.SetFont(font)
        wd,ht=self.num2.GetSize()
        self.digitsize=wd
        self.num2.SetLabel('0'*(self.maxsz-len(str(nm2)))+str(nm2))
        wx.StaticBitmap(self.WorkSheetPanel,-1,wx.Bitmap('files/Hline.png'),pos=(x,y+50*3+10),size=(self.digitsize*5,5))
        self.ans=wx.StaticText(self.WorkSheetPanel,-1,'0'*self.maxsz,(x,y+50*4+10*2))
        self.ans.SetFont(font)
        tmp,self.y2=self.num2.GetSize()
        tmpstr=str(nm1)
        for i in range(self.maxsz):
            self.carry[i]=wx.StaticText(self.WorkSheetPanel,-1,'',(x+wd*i-10,y+20))
            self.carry[i].SetFont(borrow_font)  # smaller font size .. for carry
            self.num1[i]=wx.StaticText(self.WorkSheetPanel,-1,tmpstr[i],(x+wd*i-5,y+50))
            self.num1[i].SetFont(font)
            self.strike[i]=wx.StaticBitmap(self.WorkSheetPanel,-1,wx.Bitmap('files/Hline.png'),pos=(x+wd*i,y+50+self.y2/2),size=(self.digitsize,5))
            self.strike[i].Show(False)
        self.maxsz*=-1  # for setting range for CurPos
        x,y=self.num2.GetPosition()
        wx.StaticText(self.WorkSheetPanel,-1,'-',(x-self.fontsize,y)).SetFont(font)
        
        self.x1,self.y1=0,0
        self.CarryFlag=0
        self.CurPos=-1
        
        self.cursor=wx.StaticBitmap(self.WorkSheetPanel,-1,wx.Bitmap('files/HlineG.png'),pos=(0,0),size=(self.digitsize,5))
        self.cursorUp=wx.StaticBitmap(self.WorkSheetPanel,-1,wx.Bitmap('files/HlineG.png'),pos=(0,0),size=(self.digitsize,5))
        
        self.WorkSheetPanel.Bind(wx.EVT_PAINT,self.OnWorkSheetPaint)
        wx.EVT_LEFT_DOWN(self.MenuPanel,self.OnLeftClick) #Mouse Event
        wx.EVT_LEFT_DOWN(self.WorkSheetPanel,self.OnLeftClick) #Mouse Event
        wx.EVT_LEFT_DOWN(self.MainPanel,self.OnLeftClick) #Mouse Event
        self.WorkSheetPanel.Bind(wx.EVT_KEY_DOWN, self.OnKeyDown)   #Key Event
        self.WorkSheetPanel.SetFocus()
        self.color='#33aa43'
        self.PaintLabel()
        
        vbox=wx.BoxSizer(wx.VERTICAL)
        vbox.Add(self.MenuPanel,0)
        vbox.Add(self.WorkSheetPanel,0)
        self.MainPanel.SetSizer(vbox)
        #self.WorkSheetPanel.SetFocus()
        self.ShowFullScreen(True)
        self.Show(True)
        # WorkSheet Initialisation ends..
        self.ChangeButCur(None)
        self.MenuTimer.Start(self.speed) # Timer for Menu Cursor Movement,...
    # Menu Handlers Starts..
    def OnButtonClick(self,event):
        tmp=self.ButtonIndex
        self.ButtonIndex=event.GetId()
        tmpG=self.Group
        if self.ButtonIndex>9:
            self.Group=2
        else:
            self.Group=1
        self.OnLeftClick(None)
        self.ButtonIndex=tmp
        self.Group=tmpG
    def OnKeyDown(self,event):
        key=event.GetKeyCode()
        if key>=ord('0') and key<=ord('9'):
            self.OnDigitPress(str(key-ord('0')))
            self.PaintLabel()
    def OnMenuPaint(self,event):
        paint=wx.PaintDC(self.MenuPanel)
        paint.SetPen(wx.Pen('#000000'))
        paint.SetBrush(wx.Brush('#dd2222'))
        paint.DrawRoundedRectangle(self.Mx1,self.My1,self.wdt,self.ht,10)
    def OnLeftClick(self,event):
        if self.Group==0:
            self.Group=self.ButtonIndex+1
            self.ButtonIndex=self.ButtonIndex*10-1
            self.MenuTimer.Start(500)
        elif self.Group==1:
            #Digits Pressed
            self.OnDigitPress(str(self.ButtonIndex))
            self.Group=0
        elif self.Group==2:
            if self.ButtonIndex==10:  #-->
                if self.CurPos<-1:
                    self.CurPos+=1
            elif self.ButtonIndex==11:  #<--
                if self.CurPos>self.maxsz:
                    self.CurPos-=1
            elif self.ButtonIndex==12:  #Carry-Toggle
                if self.CarryFlag==1:   # In Carry.. so next have to Goto Borrow
                    self.butList[12].SetLabel('Goto Borrow')
                else:
                    self.butList[12].SetLabel('Go Back')
                self.CarryFlag=(self.CarryFlag+1)%2 #Toggle logic
            elif self.ButtonIndex==13:  #Evaluate
                pass
            else:                       #Exit
                self.Close()
            self.Group=0
        self.PaintLabel()
        self.WorkSheetPanel.SetFocus()
        self.ChangeButCur(None)
    def ChangeButCur(self,event):
        if self.Group==0:
            self.ButtonIndex=(self.ButtonIndex+1)%2
            self.Mx1,self.My1=self.butList[self.ButtonIndex*10].GetPosition()
            self.wdt,self.ht=self.butList[0].GetSize()  #for getting ht alone..
            self.Mx1,self.My1=self.Mx1-5,self.My1-5
            twd,tht=wx.GetDisplaySize()
            self.wdt,self.ht=twd-70,self.ht+10
        else:
            if self.Group==1:
                self.ButtonIndex=(self.ButtonIndex+1)%10
            else:
                self.ButtonIndex=(self.ButtonIndex+1-10)%(len(self.butList)-10)+10
            #Voice Playing...
            if self.butList[self.ButtonIndex].GetLabel()=="-->":
                snd=wx.Sound('files/voice/MoveRight.wav')
            elif self.butList[self.ButtonIndex].GetLabel()=="<--":
                snd=wx.Sound('files/voice/MoveLeft.wav')
            else:
                snd=wx.Sound('files/voice/'+self.butList[self.ButtonIndex].GetLabel()+'.wav')
            snd.Play()
            #Voice ends..
            self.Mx1,self.My1=self.butList[self.ButtonIndex].GetPosition()
            self.wdt,self.ht=self.butList[self.ButtonIndex].GetSize()
            self.Mx1,self.My1=self.Mx1-5,self.My1-5
            self.wdt,self.ht=self.wdt+10,self.ht+10
        self.Refresh()
        self.MenuTimer.Start(self.speed)
    # Menu Handlers Ends..
    
    # Worksheet Handlers starts..
    def OnWorkSheetPaint(self,event):
        dc=wx.PaintDC(self.WorkSheetPanel)
        dc.SetPen(wx.Pen('#dd0022'))
        dc.SetBrush(wx.Brush(self.color))
        #dc.DrawRectangle(self.x1,self.y1,self.fontsize,self.y2)
        if self.CarryFlag==0:
            self.cursor.SetPosition((self.x1,self.y1+self.y2-5))
        else:
            self.cursor.SetPosition((self.x1,self.y1+self.y2-20))
        self.cursorUp.SetPosition((self.x1,self.y1))
        
    def PaintLabel(self):
        if self.CarryFlag==1:
            LabelObj=self.carry[self.CurPos]
            if len(LabelObj.GetLabel())>=2:
                self.x1,self.y1=LabelObj.GetPosition()
            else:
                self.x1,self.y1=LabelObj.GetPosition()
                wd,ht=LabelObj.GetSize()
                self.x1+=wd
        else:
            self.x1,self.y1=self.ans.GetPosition()
            wd,ht=self.ans.GetSize()
            self.x1+=wd
            if self.CurPos!=0:
                self.x1+=self.CurPos*self.digitsize # note CurPos is -ve
            else:
                txt=str(int(self.ans.GetLabel()))
                self.x1-=len(txt)*self.digitsize
        self.Refresh()
    def OnDigitPress(self,digit):
        if self.CarryFlag==1:
            LabelObj=self.carry[self.CurPos]
            txt=LabelObj.GetLabel()
            if len(LabelObj.GetLabel())>=2 or LabelObj.GetLabel()=='0':
                LabelObj.SetLabel(digit)
            else:
                LabelObj.SetLabel(txt+digit)
                self.strike[self.CurPos].Show(True)
            if LabelObj.GetLabel()==self.num1[self.CurPos].GetLabel():
                self.strike[self.CurPos].Show(False)
        else:
            txt=self.ans.GetLabel() #to remove leading zeros
            if self.CurPos==-1:
                txt=txt[:-1]+digit
            else:
                txt=txt[:self.CurPos]+digit+txt[self.CurPos+1:]
            if self.CurPos>self.maxsz-1 and self.CarryFlag==0:
                self.CurPos-=1
            tmp='0'*(abs(self.maxsz)-len(txt))+txt
            self.ans.SetLabel(tmp)
if __name__=='__main__':
    app=wx.App()
    subtraction(None,-1,"Subtraction",3221,792,30,2000)
    app.MainLoop()
