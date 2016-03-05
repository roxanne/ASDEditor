package asd.asdeditor;
import javax.swing.*;
import java.awt.*;

 
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
 
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
 
public class JSplitPaneExt extends JFrame implements PropertyChangeListener  {
 
	public JSplitPaneExt()  {
		super ("Split pane test");
		
		//  Create the components to show in the split pane
		myTopComponent = new JTextArea ("This is the top component", 10, 40);
		myBottomComponent = new JTextArea ("This is the bottom component", 15, 40);
		
		//  Create the split pane
		mySplitter = new JSplitPane (JSplitPane.VERTICAL_SPLIT , true, myTopComponent, myBottomComponent);
		mySplitter.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, this);
		
		getContentPane ().setLayout(new BorderLayout ());
		getContentPane ().add (mySplitter, BorderLayout.CENTER);
	}
		
	
	public void propertyChange (PropertyChangeEvent evt) {
		if (evt.getPropertyName () == JSplitPane.DIVIDER_LOCATION_PROPERTY)  {
			System.out.println ("Split pane divider moved");
			
			Dimension size = myTopComponent.getSize ();
			System.out.println ("    The top component's size is: " + size.height +" h, "+ size.width + " w");
			
			myBottomComponent.getSize (size);
			System.out.println ("    The bottom component's size is: " + size.height +" h, "+ size.width + " w");
			
			mySplitter.getSize (size);
			System.out.println ("    The splitter's size is: " + size.height +" h, "+ size.width + " w");
			System.out.println ("    The splitter divider location is: " + mySplitter.getDividerLocation ());
		}
	}
	
	private JTextArea myTopComponent;
	private JTextArea myBottomComponent;
	private JSplitPane mySplitter;
	
	public static void main(String[] args) {
 
		JSplitPaneExt appFrame = new JSplitPaneExt ();
		
		appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		appFrame.pack();
		appFrame.setVisible (true);		
	}
}

//
//public class JSplitPaneExt extends JSplitPane
//{
//protected boolean IsPainted=false;
//protected double ProportionalLocation=-1;
//public JSplitPaneExt()
//{
//super();
//}
//public JSplitPaneExt(int iOrientation)
//{
//super(iOrientation);
//}
//protected boolean hasProportionalLocation()
//{
//return (ProportionalLocation != -1);
//}
//public void cancelDividerProportionalLocation()
//{
//ProportionalLocation = -1;
//}
////public void setDividerLocation(double dProportionalLocation)
////{
////if (dProportionalLocation < 0 || dProportionalLocation > 1)
////throw new IllegalArgumentException("Illegal value for divider location: "+dProportionalLocation);
////ProportionalLocation=dProportionalLocation;
////if (IsPainted)
////super.setDividerLocation(ProportionalLocation);
////}
//  //  public void setDividerLocation(double proportionalLocation) {
//     //   if (!isPainted) {       
//        //    hasProportionalLocation = true;
//         //   this.proportionalLocation = proportionalLocation;
//       // }
//       // else
//           // super.setDividerLocation(proportionalLocation);
//  //  }
//
//    //public void paint(Graphics g) {
//      //  if (!isPainted) {       
//        //    if (hasProportionalLocation)
//         //       super.setDividerLocation(proportionalLocation);
//         //   isPainted = true;
//       // }
//       // super.paint(g);
//  //  } 
//    @Override
// public void setDividerLocation(double proportionalLocation)
//   {
//     if (proportionalLocation > 1 || proportionalLocation < 0)
//       throw new IllegalArgumentException
//         ("proportion has to be between 0 and 1.");
//   
//   int max = ((orientation == HORIZONTAL_SPLIT) ? getWidth() : getHeight())
//          - getDividerSize();
//     setDividerLocation((int) (proportionalLocation * max)); 
//   } 
//public void paint(Graphics g)
//{
//super.paint(g);
//if (hasProportionalLocation())
//super.setDividerLocation(ProportionalLocation);
//IsPainted=true;
//}
//
//}
//   // splitPane.addPropertyChangeListener(propertyChangeListener);
//
//
