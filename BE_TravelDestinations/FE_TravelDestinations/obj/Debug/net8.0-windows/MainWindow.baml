   M S B A M L   `   `   `  ����P  LFE_TravelDestinations, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null=#clr-namespace:FE_TravelDestinationsFE_TravelDestinations  5   	   &     FE_TravelDestinations.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   5local#clr-namespace:FE_TravelDestinations     5   	     � Title$  Main window��5   	   $	��450��6   $	��900��6*   .��5	      � 
�������$��0,0,0,-6q�6    � ColumnDefinitions 5
   
   �� 5      $
��451* �6   �� 5      $��1149* �6   .+�5   
   �� -   5        $��
Fetch data��5      $��Center=�6&   $��0,49,0,0q�6C   $	��Top=�6U   $��54��6m   $	��218��6y   6�   � 5   
   $��10,0,10,320q�6   $��54��6$   $��Bottom=�60   $��2��6K    5      �� 5      $	��13* �6#   �� 5      $	��28* �6#   �� 5      $
��141* �6#   �� 5      $
��598* �6#   .+�5      &   System.Windows.Controls.DataGrid  -   5          Name$ dataGrid��5      $��85,-20,135,-279q�6)   $��3��6a   5      �� 5   
   -   5        $	��Add��5      $��Center=�6   $��	0,125,0,0q�6<   $	��Top=�6O   $��54��6g   $	��218��6s   6   �� 5   
   -   5         ��Name$ 	btnDelete��5      $��Delete��6$   $��Center=�65   $��	0,307,0,0q�6R   $	��Top=�6e   $��54��6}   $	��218��6�   $
{�True��6�   �� 5   
   -   5        $ 	btnUpdate��5      $��Update destination name��6$   $��Center=�6F   $��	0,220,0,0q�6c   $	��Top=�6v   $��54��6�   $	��218��6�   $
{�True��6�   �� 5   
   -   5        $��Close��5      $
��Bold"�6!   $��1136,829,13,0q�63   $	��Top=�6J   $��45��6v   $��1��6�   5      5      