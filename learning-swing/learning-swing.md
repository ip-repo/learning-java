# Swing
### 1: Date and Time program
<img src="example_1_date_time/example1_date_time.png" width="200" height="200">

<a href="https://github.com/ip-repo/learning-java/tree/main/learning-swing/example_1_date_time">This example</a> `extends` a `JFrame` swing object and create a window that has a centred label with the current
date and time.

How to run the example:

```console
git clone https://github.com/ip-repo/learning-java.git
cd learning-java/learning-swing/example_1_date_time
javac main.java
java main
```

You some can change some settings to get a different program style `DateAndTime.java`:

```Java
//line 23 and 38 : date and time format for example : "... HH:MM ..."
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
//line 26 : Font settings
Font font = new Font("Algerian", Font.BOLD, 30);
//line 32 : label text color
label.setForeground(Color.white);
//line 49 : background color
this.getContentPane().setBackground(new Color(76,60,130));

```


