// A Simple WPF Application, written XMAL-Free.
using System;
using System.Windows;
using System.Windows.Controls;

namespace SimpleWPFApp
{
	// Our application object.
	class MyWPFApp : Application
	{
		[STAThread]
		static void Main(string[] args)
		{				
			// Handle the Startup and Exit events, then run the application.
			MyWPFApp app = new MyWPFApp();
			app.Startup += new StartupEventHandler(AppStartUp);
			app.Exit += new ExitEventHandler(AppExit);
			app.Run();  // Fires the Startup event.
		}
		
		static void AppExit(object sender, ExitEventArgs e)
		{
			MessageBox.Show("App has exited");
		}
		
		static void AppStartUp(object sender, StartupEventArgs e)
		{	  
			// Create a MainWindow object. 
			MainWindow wnd = new MainWindow("My better WPF App!", 200, 300);
		}
	}

	class MainWindow : Window
	{
		// Our UI element.
		private Button btnExitApp = new Button();
		
		public MainWindow(string windowTitle, int height, int width)
		{
			// Configure button and add to collection.
			btnExitApp.Click += new RoutedEventHandler(btnExitApp_Clicked);
			btnExitApp.Content = "Exit Application";
			btnExitApp.Height = 25;
			btnExitApp.Width = 100;
			this.AddChild(btnExitApp);
			
			// Configure the window.
			this.Title = windowTitle;
			this.WindowStartupLocation = WindowStartupLocation.CenterScreen;
			this.Height = height;
			this.Width = width;
			this.Show();		
		}
		
		private void btnExitApp_Clicked(object sender, RoutedEventArgs e)
		{
			// Get a handle to the current app and shut it down.
			Application.Current.Shutdown();
		}
	}
}