 // asddemo2 - 2004 Jan. 21
package asd.asdeditor;

//import asd.*;


import java.applet.*;
import java.io.*;
import java.lang.reflect.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;

public class ASDEditorApplet extends JApplet implements Runnable {

  

    /** The ASDEditor */
    private ASDEditor asdeditor;

   

    /** The thread where the ASDTester is run */
    private Thread editorThread;

    /** If the ASDTester thread has already been started */
    private boolean editorStarted;

   
    /**
     * Initializes the applet. It creates the ASDEditor
     * thread.
     * */
    public void init() {
       
        validate();
        setVisible(true);
        // Set a thread to run the applet
        editorThread = new Thread(this);
        editorStarted = false;
    }

    /**
     * Starts the ASDTester thread.
     * */
    public void start() {
        if (editorStarted) return; // already started => nothing to do
        editorStarted = true;
        editorThread.start();
    }

  
    public void stop() {
        // Nothing here for now!
    }

    /**
     * Waits for the ASDtester thread to end and sets it to null.
     * */
    public void destroy() {
        if (!editorStarted) return;
        while (editorThread != null && editorThread.isAlive()) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
            }
        }
        editorThread = null;
    }

    public void run() {
        
        int status;

        if (asdeditor != null) return; // already running an ASDTester
        showStatus("Initializing ASDEditor...");
        // Create and start the ASDEditor
        //asdeditor = new ASDEditor();
        
	try
	    {
		asdeditor = new ASDEditor(); showStatus("ASDEditor running ...");
	    }
	catch(ClassNotFoundException e)
	    {}
	catch (InvocationTargetException e)
	    {}
	catch (InstantiationException e)
	    {}
	catch (IllegalAccessException e)
	    {}


        showStatus("ASDEditor running ...");
	
       
    }

}
