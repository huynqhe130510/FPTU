/**
 * Show console
 */
 
[System.Runtime.InteropServices.DllImport("kernel32.dll")]
private static extern bool AllocConsole();
public Form()
{
    AllocConsole();
    InitializeComponent();
}