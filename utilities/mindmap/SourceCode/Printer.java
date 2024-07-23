/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
/**
 *
 * @author Sakthi
 */
public class Printer implements Printable {
    public Printer()
    {
         PrinterJob printJob = PrinterJob.getPrinterJob();
      printJob.setPrintable(this);
      if (printJob.printDialog()) {
        try {
          printJob.print();
        } catch (Exception ex) {
          ex.printStackTrace();
        }
    }
    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)  {
         if (pageIndex >= 1) {
      return Printable.NO_SUCH_PAGE;
    }

         graphics.setColor(Color.WHITE);
graphics.fillRect(0,0,(int)pageFormat.getWidth(),(int)pageFormat.getHeight());
graphics.translate(-100,-100);
Mind.flagClearRect=true;
        Mind.Obj_Drawing.paint(graphics);
        return Printable.PAGE_EXISTS;
    }

}
