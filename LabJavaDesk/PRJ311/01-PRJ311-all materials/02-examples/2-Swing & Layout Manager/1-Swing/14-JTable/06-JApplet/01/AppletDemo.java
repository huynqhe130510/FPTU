import java.awt.*;
import java.applet.*;
import javax.swing.*;

public class AppletDemo extends JApplet
	{
	public void init()
	{
	final String[] colhead={"Name","Institution","Place"};
	final String[][]data={
				{"Prince","SAKEC","London"},
				{"Jasmine","VJTI","Tokyo"},
				{"Johny","MIT","Bangkok"},
				{"Mary","BVP","Auckland"},
				{"Eric","RAIT","Miami"},
				{"Rose","SVEC","Cape Town"},
				{"Samson","CEOP","Sydney"},
				{"Lovely","SPCE","Dubai"},
				{"Paul","FAEC","Colombo"},
				{"Angela","TSEC","Cairo"},
				{"Mathew","VEC","Paris"},
				{"Alice","SSEC","Bonn"},
				{"Tony","UDCT","Harare"},
			     };
	JTable tab=new JTable(data,colhead);
	int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	JScrollPane jsp=new JScrollPane(tab,v,h);
	getContentPane().add(jsp,BorderLayout.CENTER);  
	}
	}

