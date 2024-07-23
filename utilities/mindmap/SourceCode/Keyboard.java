import java.awt.*;
import javax.swing.*;


public class Keyboard extends JPanel
{
JPanel key1,key2,key3,key4,key;
static JButton bdown1,bup1,bdown2,bup2,bdown3,bup3,b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bbackspace1,benter1,bbackspace2,benter2,bbackspace3,benter3,bcaps,bcomm,bdot;
static JButton ba,bb,bc,bd,be,bf,bg,bh,bi,bj,bk,bl,bm,bn,bo,bp,bq,br,bs,bt,bu,bv,bw,bx,by,bz;

public Keyboard()
{

key1=new JPanel();
key2=new JPanel();
key3=new JPanel();
key4=new JPanel();
key=new JPanel();
setLayout(new GridLayout(1,1));

java.awt.Font font1 = new Font(Mind.btnFont.getFontName(),Mind.btnFont.getStyle(),Mind.btnFont.getSize()-6);

bdown1= new JButton("Down");
bup1= new JButton("Up");
bdown2= new JButton("Down");
bup2= new JButton("Up");
bdown3= new JButton("Down");
bup3= new JButton("Up");

b1= new JButton("1");
b2= new JButton("2");
b3= new JButton("3");
b4= new JButton("4");
b5= new JButton("5");
b6= new JButton("6");
b7= new JButton("7");
b8= new JButton("8");
b9= new JButton("9");
b0= new JButton("0");

bbackspace1= new JButton("Clear");
benter1= new JButton("Enter");

bbackspace2= new JButton("Clear");
benter2= new JButton("Enter");

bbackspace3= new JButton("Clear");
benter3= new JButton("Enter");

bcaps= new JButton("CAPS");
bcomm=new JButton(",");
bdot=new JButton(".");

bdown1.setFont(font1);
bup1.setFont(font1);
bdown2.setFont(font1);
bup2.setFont(font1);
bdown3.setFont(font1);
bup3.setFont(font1);


b1.setFont(font1);
b2.setFont(font1);
b3.setFont(font1);
b4.setFont(font1);
b5.setFont(font1);
b6.setFont(font1);
b7.setFont(font1);
b8.setFont(font1);
b9.setFont(font1);
b0.setFont(font1);
bbackspace1.setFont(font1);
benter1.setFont(font1);

bbackspace2.setFont(font1);
benter2.setFont(font1);

bbackspace3.setFont(font1);
benter3.setFont(font1);

bcaps.setFont(font1);
bcomm.setFont(font1);
bdot.setFont(font1);


bdown1.setForeground(Mind.btnForecolor);
bup1.setForeground(Mind.btnForecolor);
bdown2.setForeground(Mind.btnForecolor);
bup2.setForeground(Mind.btnForecolor);
bdown3.setForeground(Mind.btnForecolor);
bup3.setForeground(Mind.btnForecolor);


b1.setForeground(Mind.btnForecolor);
b2.setForeground(Mind.btnForecolor);
b3.setForeground(Mind.btnForecolor);
b4.setForeground(Mind.btnForecolor);
b5.setForeground(Mind.btnForecolor);
b6.setForeground(Mind.btnForecolor);
b7.setForeground(Mind.btnForecolor);
b8.setForeground(Mind.btnForecolor);
b9.setForeground(Mind.btnForecolor);
b0.setForeground(Mind.btnForecolor);
bbackspace1.setForeground(Mind.btnForecolor);
benter1.setForeground(Mind.btnForecolor);

bbackspace2.setForeground(Mind.btnForecolor);
benter2.setForeground(Mind.btnForecolor);

bbackspace3.setForeground(Mind.btnForecolor);
benter3.setForeground(Mind.btnForecolor);

bcaps.setForeground(Mind.btnForecolor);
bcomm.setForeground(Mind.btnForecolor);
bdot.setForeground(Mind.btnForecolor);

bdown1.setBackground(Mind.btnBackcolor);
bup1.setBackground(Mind.btnBackcolor);
bdown2.setBackground(Mind.btnBackcolor);
bup2.setBackground(Mind.btnBackcolor);
bdown3.setBackground(Mind.btnBackcolor);
bup3.setBackground(Mind.btnBackcolor);


b1.setBackground(Mind.btnBackcolor);
b2.setBackground(Mind.btnBackcolor);
b3.setBackground(Mind.btnBackcolor);
b4.setBackground(Mind.btnBackcolor);
b5.setBackground(Mind.btnBackcolor);
b6.setBackground(Mind.btnBackcolor);
b7.setBackground(Mind.btnBackcolor);
b8.setBackground(Mind.btnBackcolor);
b9.setBackground(Mind.btnBackcolor);
b0.setBackground(Mind.btnBackcolor);
bbackspace1.setBackground(Mind.btnBackcolor);
benter1.setBackground(Mind.btnBackcolor);

bbackspace2.setBackground(Mind.btnBackcolor);
benter2.setBackground(Mind.btnBackcolor);

bbackspace3.setBackground(Mind.btnBackcolor);
benter3.setBackground(Mind.btnBackcolor);

bcaps.setBackground(Mind.btnBackcolor);
bcomm.setBackground(Mind.btnBackcolor);
bdot.setBackground(Mind.btnBackcolor);


ba= new JButton("A");
bb= new JButton("B");
bc= new JButton("C");
bd= new JButton("D");
be= new JButton("E");
bf= new JButton("F");
bg= new JButton("G");
bh= new JButton("H");
bi= new JButton("I");
bj= new JButton("J");
bk= new JButton("K");
bl= new JButton("L");
bm= new JButton("M");
bn= new JButton("N");
bo= new JButton("O");
bp= new JButton("P");
bq= new JButton("Q");
br= new JButton("R");
bs= new JButton("S");
bt= new JButton("T");
bu= new JButton("U");
bv= new JButton("V");
bw= new JButton("W");
bx= new JButton("X");
by= new JButton("Y");
bz= new JButton("Z");

ba.setFont(font1);
bb.setFont(font1);
bc.setFont(font1);
bd.setFont(font1);
be.setFont(font1);
bf.setFont(font1);
bg.setFont(font1);
bh.setFont(font1);
bi.setFont(font1);
bj.setFont(font1);
bk.setFont(font1);
bl.setFont(font1);
bm.setFont(font1);
bn.setFont(font1);
bo.setFont(font1);
bp.setFont(font1);
bq.setFont(font1);
br.setFont(font1);
bs.setFont(font1);
bt.setFont(font1);
bu.setFont(font1);
bv.setFont(font1);
bw.setFont(font1);
bx.setFont(font1);
by.setFont(font1);
bz.setFont(font1);


ba.setForeground(Mind.btnForecolor);
bb.setForeground(Mind.btnForecolor);
bc.setForeground(Mind.btnForecolor);
bd.setForeground(Mind.btnForecolor);
be.setForeground(Mind.btnForecolor);
bf.setForeground(Mind.btnForecolor);
bg.setForeground(Mind.btnForecolor);
bh.setForeground(Mind.btnForecolor);
bi.setForeground(Mind.btnForecolor);
bj.setForeground(Mind.btnForecolor);
bk.setForeground(Mind.btnForecolor);
bl.setForeground(Mind.btnForecolor);
bm.setForeground(Mind.btnForecolor);
bn.setForeground(Mind.btnForecolor);
bo.setForeground(Mind.btnForecolor);
bp.setForeground(Mind.btnForecolor);
bq.setForeground(Mind.btnForecolor);
br.setForeground(Mind.btnForecolor);
bs.setForeground(Mind.btnForecolor);
bt.setForeground(Mind.btnForecolor);
bu.setForeground(Mind.btnForecolor);
bv.setForeground(Mind.btnForecolor);
bw.setForeground(Mind.btnForecolor);
bx.setForeground(Mind.btnForecolor);
by.setForeground(Mind.btnForecolor);
bz.setForeground(Mind.btnForecolor);


ba.setBackground(Mind.btnBackcolor);
bb.setBackground(Mind.btnBackcolor);
bc.setBackground(Mind.btnBackcolor);
bd.setBackground(Mind.btnBackcolor);
be.setBackground(Mind.btnBackcolor);
bf.setBackground(Mind.btnBackcolor);
bg.setBackground(Mind.btnBackcolor);
bh.setBackground(Mind.btnBackcolor);
bi.setBackground(Mind.btnBackcolor);
bj.setBackground(Mind.btnBackcolor);
bk.setBackground(Mind.btnBackcolor);
bl.setBackground(Mind.btnBackcolor);
bm.setBackground(Mind.btnBackcolor);
bn.setBackground(Mind.btnBackcolor);
bo.setBackground(Mind.btnBackcolor);
bp.setBackground(Mind.btnBackcolor);
bq.setBackground(Mind.btnBackcolor);
br.setBackground(Mind.btnBackcolor);
bs.setBackground(Mind.btnBackcolor);
bt.setBackground(Mind.btnBackcolor);
bu.setBackground(Mind.btnBackcolor);
bv.setBackground(Mind.btnBackcolor);
bw.setBackground(Mind.btnBackcolor);
bx.setBackground(Mind.btnBackcolor);
by.setBackground(Mind.btnBackcolor);
bz.setBackground(Mind.btnBackcolor);


key1.setLayout(new GridLayout(1,13));

key1.add(bdown1);
key1.add(b1);
key1.add(b2);
key1.add(b3);
key1.add(b4);
key1.add(b5);
key1.add(b6);
key1.add(b7);
key1.add(b8);
key1.add(b9);
key1.add(b0);
key1.add(bbackspace1);
key1.add(benter1);

key2.setLayout(new GridLayout(1,13));
key2.add(bdown2);
key2.add(bq);
key2.add(bw);
key2.add(be);
key2.add(br);
key2.add(bt);
key2.add(by);
key2.add(bu);
key2.add(bi);
key2.add(bo);
key2.add(bp);
key2.add(bbackspace2);
key2.add(bup1);

key3.setLayout(new GridLayout(1,13));
key3.add(bdown3);
key3.add(bcaps);
key3.add(ba);
key3.add(bs);
key3.add(bd);
key3.add(bf);
key3.add(bg);
key3.add(bh);
key3.add(bj);
key3.add(bk);
key3.add(bl);
key3.add(benter2);
key3.add(bup2);


key4.setLayout(new GridLayout(1,12));
key4.add(bz);
key4.add(bx);
key4.add(bc);
key4.add(bv);
key4.add(bb);
key4.add(bn);
key4.add(bm);
key4.add(bcomm);
key4.add(bdot);
key4.add(bbackspace3);
key4.add(benter3);
key4.add(bup3);
key.setLayout(new GridLayout(4,1));
key.add(key1);
key.add(key2);
key.add(key3);
key.add(key4);
 add(key);
}

public static void start()
{
KeyboardThread kt=new KeyboardThread(bdown1,b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bbackspace1,benter1,bdown2,bq,bw,be,br,bt,by,bu,bi,bo,bp,bbackspace2,bup1,bdown3,bcaps,ba,bs,bd,bf,bg,bh,bj,bk,bl,benter2,bup2,bz,bx,bc,bv,bb,bn,bm,bcomm,bdot,bbackspace3,benter3,bup3);

}


}


