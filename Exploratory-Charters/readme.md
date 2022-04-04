# Monefy Exploratory Testing Charters

This File contains all the Exploratory Testing Charters for the Monefy Android Application

**Note** - The Charters have been sorted based on its priority


| Charter 	| To verify all the features in the Dashboard page 	|
|---	|---	|
| Priority 	| 1 	|
| Tester Name 	| Vignesh S 	|
| App Version 	| 1.16.0 	|
| Duration 	| 40 minutes 	|
| Test Idea Notes 	| 1. Once the application loads, it lands on the Dashboard page post the introduction tour slides.<br>2. It has icons of all the expense types such as Bills, Gifts etc. But no icon for income types such as salary, savings etc.<br>3. Long pressing on any particular expense shows the amount spent in green colour. As its an expense it should not show green as its for income.<br>4. If having expense for multiple month for example March, April and right sliding and focusing on April and clicked on Income/Expense - by default it takes current date and not on the month selected<br>5. Order of the icons around the circle is not constant. It varies based on percentage.<br>6. When there is no account, then when clicking on Add expense/income displays to "Add New Account" section. 	|
| Defects/Issues/Enhancements 	| 1. Under Balance section, when clicked on any of the entry and made changes in the amount, no option to cancel. Clicking on back button save the changes.<br>2. In search mode, when clicking on outside the search box, does not close the search bar.<br>3. No icon or text information to display what mode does the expense or income happened such as Cash/ Card.<br>4. Unable to view the new transfer made in the dashboard.<br>5. Does not show what all Currency type supports in dashboard. Shows only default currency(Pound). Even though other currencies are supported in Show currencies page user will not know it unless he sees the right tab.<br>6. App Home tour is very minimum. Does not include about all major features.<br>7. When selected calendar and click on Edit button. And when manually deleted date and trying to enter wrong date it gives only generic message. For example when entering date as 55 it gives error message as Invalid format.<br>8. Data format shows is dd/mm/y . Where actually cannot enter a single number for year. Error message is wrong<br>9. When any of the expense icon (Clothes) is long pressed --> It displays that particular expense is centre circle. But when single clicking the icon it traverse to the next expense adding page. But before traversing for 0.5 sec it displays that icon inside the circle. But that too not clearly. It shows intermittently.<br>10. Clicked on the balance button and clicked on an entry and edited value in it. Post editing it shows the balance sheet of next month and not which one edited.<br>11. Under search, no option to clear recent search text. 	|


| Charter 	| To verify the Categories feature from the right side tab 	|
|---	|---	|
| Priority 	| 2 	|
| Tester Name 	| Vignesh S 	|
| App Version 	| 1.16.0 	|
| Duration 	| 26 minutes 	|
| Test Idea Notes 	| 1. Unable to choose different icon for a Category. Need to purchase pro version for that.<br>2. Unable to add new Category. Need to purchase pro version for that.<br>3. Changing a category name reflects in the dashboard and in the Balance page as expected.<br>4. No Character limit when changing name for a category. Allows any number of characters.<br>5. Character Name is not allowing to save empty value as expected.<br>6. Able to remove a category. But all the corresponding records tagged to those category also gets deleted.<br>7. Able to Disable a category. Once a category is disabled it does not show that in the list when adding new entry. But if there are entires present before disabling a category it still shows those entries.<br>8. Once the category is closed, under the right tab Categories section it displays the Disabled category at bottom.<br>9. Able to enable a disabled category.<br>10. When 2 Categories are merged, entries from the 1st Category moves to the 2nd Category. For example when we open "Clothes" category and click on merge and choose "Communication", then all the Clothes tagged entires gets tagged to Communication.<br>11. When a category is merged with other Category, the merged category name gets removed from the Categories Section. 	|
| Defects/Issues/Enhancements 	| 1. Once a category is merged, unable to revert it back.<br>2. No alert message or warning to display when a Category is getting merge.<br>3. If a Category is disabled, and when adding a new Entry, it does not show the disabled category even in greyed out way. User will not know that there are some Disabled categories from the Dashboard page. 	|


| Charter 	| To verify the Accounts feature from the right side tab 	|
|---	|---	|
| Priority 	| 3 	|
| Tester Name 	| Vignesh S 	|
| App Version 	| 1.16.0 	|
| Duration 	| 20 minutes 	|
| Test Idea Notes 	| 1. Accounts section displays as 2nd under the Right Side tab<br>2. When opened the Accounts tab, by default it displays 2 types - Cash & Payment Card<br>3. Able to edit a Account type name<br>4. Unable to edit the Account Currency - Need to purchase pro version.<br>5. When "Included in the balance" toggle is ON, then "Initial Account Balance" is getting added to the Balance section in Dashboard section.<br>6. Able to delete an existing Account type. It does displays a warning when deleting.<br>7. When 2 Accounts are merged amount from the 1st Account moves to the 2nd Account. And also the 1st Account is removed from the Accounts section.<br>8. Able to disable an existing account.<br>9. When initiating a new transfer, unable to select the amount place holder when both from and to account are same. Throws a warning as "Accounts have to be different"<br>10. When a transaction is made from Account 1 to Account 2 - Corresponding amount is deducted from Account 1 and gets credited to Account 2 	|
| Defects/Issues/Enhancements 	| 1. Able to select both past & future date in "Initial Balance Date"<br>2. When creating a new Account type, the Name box displays the word "Name" in bold. User can get confused when he is trying to delete that word but it does not get removed. That word need to disappear once the user clicks on that text box.<br>3. When creating a new Account type, and clicking on the Name text box it does not display the cursor. User will not know if he actually clicked on it until he see a cursor.<br>4. Allows to delete all Account type. Does not give any warning when all the Account type is removed. <br>5. When editing an existing account, and click on back button it automatically saves the changes. No way to cancel the changes if done any change accidentally.<br>6. If an existing account is disable, then the balance of that account is not removed from the Dashboard balance.<br>7. Under Accounts tab no option to see the transactions made for each account. 	|


| Charter 	| To verify the Settings feature from the right side tab 	|
|---	|---	|
| Priority 	| 4 	|
| Tester Name 	| Vignesh S 	|
| App Version 	| 1.16.0 	|
| Duration 	| 35 minutes 	|
| Test Idea Notes 	| Balance Section:<br>1. By default the "Budget Mode" is disabled<br>2. When the "Budget Mode" is enabled - it displays the budget amount in Blue colour in the dashboard centre circle.<br>3. Able to disable "Budget Mode" which was previously enabled.<br>4. By default the "Carry Over" is disabled<br>5. When the "Carry Over" is enabled - it displays the carried forward amount in Dark Green colour in the dashboard centre circle.<br>6. For a month if there is balance in the carry over section, it carries forward to the next month.<br>7. Able to disable "Carry Over" which was previously enabled.<br><br>General Settings Section:<br>1. Clicking on "Unlock Monefy Pro" enables option to unlock the pro version.<br>2. Unable to enable "Dark Theme" - It requires to unlock the pro version.<br>3. Able to change language. By default the application comes with "English" language.<br>4. Able to change currency as expected.<br>5. Under the "Change currency" section, can able to search for the currency name by both full name or the short form.<br>6. Unable to enable"Password Protection" - It requires to unlock the pro version.<br>7. Once clicked on "Review Application" - It navigates to the play store as expected.<br>8. Able to export file in various format with different delimiters and decimal points.<br>9. Clicking on "About Monefy" - displays the details about the app.<br>10. Under "About Monefy" can able to enable or disable the Google Analytics.<br>11. Clicking on "Privacy Policy" opens the corresponding privacy details in the default browser.<br>12. Clicking on "Copy Purchase ID" - copies the purchase id.<br><br>Synchronisation:<br>1. Unable to enable "Dropbox" - It requires to unlock the pro version.<br>2. Unable to enable "Google Drive" - It requires to unlock the pro version.<br><br>Data Back up:<br>1. Able to create a data backup by clicking on "Create data backup". It saves the backup data in the mobile internal storage.<br>2. Able to restore data by clicking on "Restore data". Need to choose the previously saved backup from the mobile storage.<br>3. Able to clear all the app data including by clicking on "Clear data". It clears all the entires from the app. 	|
| Defects/Issues/Enhancements 	| 1. When budget mode is enabled, it overwrites the Income section in the dashboard centre circle.<br>2. When "Future recurring records" is enabled, it does not display any records in the dashboard even for future dated entires.<br>3. Post changing the language - only the Date section changes to the desired language. Rest all other functionalities displays with English only.<br>4. When the "First day of Week" is changed - does not make any changes in the dashboard or in any other section.<br>5. When the "First day of Month" is changed - does not make any changes in the dashboard or in any other section. 	|


| Charter 	| To verify the Accounts selection feature from the left side tab 	|
|---	|---	|
| Priority 	| 5 	|
| Tester Name 	| Vignesh S 	|
| App Version 	| 1.16.0 	|
| Duration 	| 15 minutes 	|
| Test Idea Notes 	| 1. By default it displays "All accounts" from the left side tab.<br>2. Clicking on the drop down - displays all the existing accounts.<br>3. Changing the account - refreshes the dashboard and displays the transaction respective to that account.<br>4. When there are no account added, clicked on "All account" dropdown - displays only "All account" text. 	|
| Defects/Issues/Enhancements 	| 1. When switched to "All accounts" section it does not display the transactions made between accounts 	|


| Charter 	| To verify the Date selection feature from the left side tab 	|
|---	|---	|
| Priority 	| 6 	|
| Tester Name 	| Vignesh S 	|
| App Version 	| 1.16.0 	|
| Duration 	| 20 minutes 	|
| Test Idea Notes 	| 1. Able to select "Day" from the Date section. It displays the dashboard with entries in day order.<br>2. Able to select "Week" from the Date section. It displays the dashboard with entries in weeks order.<br>3. Able to select "Month" from the Date section. It displays the dashboard with entries in month order.<br>4. Able to select "Year" from the Date section. It displays the dashboard with entries for the entire year.<br>5. Able to select "All" from the Date section. It displays the dashboard with all the entries made so far irrespective of the dates.<br>6. Clicking on "Interval", gives option to select specific date range. Once the date range is selected, it displays the dashboard entires based on those days.<br>7. Clicking on "Choose Date", gives option to select specific date. Once the date is selected, it displays the dashboard entires based on that day.<br>8. Able to switch between any selection to other. The dashboard displays contents according to the selected date mode. 	|
| Defects/Issues/Enhancements 	| 1. Initially when the "Month" mode is selected, it displays the entires in month wise such as March, April etc. But once switched between weeks and month, now the month displays in the week format as 28 Feb - 29 Mar 	|


| Charter 	| To verify the Currencies feature from the Right side tab 	|
|---	|---	|
| Priority 	| 7 	|
| Tester Name 	| Vignesh S 	|
| App Version 	| 1.16.0 	|
| Duration 	| 20 minutes 	|
| Test Idea Notes 	| 1. Unable to select "Currencies" - It requires to unlock the pro version 	|
| Defects/Issues/Enhancements 	|  	|


| Charter 	| To verify the General functionalities 	|
|---	|---	|
| Priority 	| 8 	|
| Tester Name 	| Vignesh S 	|
| App Version 	| 1.16.0 	|
| Duration 	| 15 minutes 	|
| Test Idea Notes 	|  	|
| Defects/Issues/Enhancements 	| 1. When the app is installed for the 1st time, it installs 2 icons in the mobile. One with correct "Monefy" icon and other with "Android Icon". Clicking on it does not do any action.<br>2. But this 2 icon issue does not reproduce in all mobile. With "Realme X2" model this issue is reproducing, whereas with "Samsung Note 10" this issue does not reproduce. 	|