# 251-Assignment1-KangYuyang-JiaYimin

## Member 1 : 
     Class:  NZ172 
     Name:  Kang Yuyang 
     Student Number: 19023466 
     Commit ID: Kang Yuyang 
     
## Member 2 : 
     Class :  NZ172
     Name :  Jia Yimin
     Student Number : 19023460
     Commit ID ：JYM
     
At first, we have some files as `TestEditor.java`,`PDF.java`, `Functions.java`.<br>
`TestEditor.java` is our main function. During this file, we had written `Open`,`Save`,`Search`,`Confirm`,`Next`,`Select`,`Cut`,`Copy`,`Paste`,`Date`,`Aboutus`,Print functions.We implement these functions by some listeners. <br>
![](https://github.com/tsmagic314159/251-Assignment1-KangYuyang-JiaYimin/blob/master/Editor.png) 
### TestEditor.java
For example, when you run our program `TestEditor.java`, it wil appear a real text editor. On the top of the text editor, there is a menu, we use some JMenu and JButton to wrote it. We have `File`,`Search`,`Date`,`SCPC`,`About`. And if you click them, they will have some items. We use JMenuItem to wrote them. 
#### File
![](https://github.com/tsmagic314159/251-Assignment1-KangYuyang-JiaYimin/blob/master/file.png)<br>
If you click this item, you can see `new`,`open`,`save`,`print`,`Save as PDF`. For example, you can start a new test by `new`, open a file in text editor by `open`(If it is a odt file, we will transform it to a pdf file at first. And then we open it by pdf.), save the content of test by `save`,and print it by `print`. If you want save the file as a `.pdf`, you can click `Save as PDF`.
#### Search
![](https://github.com/tsmagic314159/251-Assignment1-KangYuyang-JiaYimin/blob/master/search.png)<br>
In this item, you can write a key word and the text editor can return all the key words in this test.  We had use a JPanel and some labels to guide people to use this function.
#### Date
![](https://github.com/tsmagic314159/251-Assignment1-KangYuyang-JiaYimin/blob/master/date.png)<br> 
According to this item, it can appear a clock to help you konw the current time clearly. And if click it, the clock will appear at the top of the text editor.
#### SCPC
![](https://github.com/tsmagic314159/251-Assignment1-KangYuyang-JiaYimin/blob/master/SCPC.png)<br> 
In this menu, we had written 4 items, `Select`,`Copy`,`Cut`,`Paste`. `Select` is a function to help people to select all content. `Copy`,`Cut` and `Paste` have the functions just like their names.
#### About 
![](https://github.com/tsmagic314159/251-Assignment1-KangYuyang-JiaYimin/blob/master/about.png)<br>
If you click this item, it will show our imformation at a new panel. We use a JPanel as a background, and use some labels to show our imformation, such as, name,class,and student number.

 
### Functions,java
It just a  file to help us to write or read a file. 


### PDF.java
It is a file to save as a pdf file.


### odt.java
It is a file to help us to read a odt type of file. We will transform a .odt file to a .pdf file, and then we open it by pdf.


### JsonResourceUtils.java
It is a file to help us to read the configuration json file. And we had set the height and width of json files.

### AppTest.java,TestSaveAndOpen.java,TestSearch.java
These files are test files which can check if `Search`,`Save` and `Open` functions are correct. If they are correct, they will pass these tests.  

### reports folder
It is a folder which have two files. The first file is  `metrics.txt` which has code size,lines od code,number of method and code complexity. Another file is `pmd.html` which has the code quality report from PMD.















