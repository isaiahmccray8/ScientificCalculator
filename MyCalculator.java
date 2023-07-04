import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculator extends JFrame implements ActionListener{
    
    private final JButton numOne = new JButton("1");
    private final JButton numTwo = new JButton("2");
    private final JButton numThree = new JButton("3");
    private final JButton numFour = new JButton("4");
    private final JButton numFive = new JButton("5");
    private final JButton numSix = new JButton("6");
    private final JButton numSeven = new JButton("7");
    private final JButton numEight = new JButton("8");
    private final JButton numNine = new JButton("9");
    private final JButton numZero = new JButton("0");
    private final JButton multiply = new JButton("×");
    private final JButton divide = new JButton("÷");
    private final JButton add = new JButton("+");
    private final JButton subtract = new JButton("˗");
    private final JButton equalSign = new JButton("=");
    private final JButton decimal = new JButton(".");
    private final JButton clear = new JButton("C");
    private final JButton squared = new JButton("x²");
    private final JButton cubeSign = new JButton("x³");
    private final JButton squareRoot = new JButton("√");
    private final JButton percent = new JButton("%");
    private final JButton modulo = new JButton("Mod");
    private final JButton reciprocal = new JButton("1/n");
    private final JButton negative = new JButton("±");

    //----------Scientific keys---------------
    private final JButton sinButton = new JButton("sin");
    private final JButton cosButton = new JButton("cos");
    private final JButton tanButton = new JButton("tan");
    private final JButton asinButton = new JButton("asin");
    private final JButton acosButton = new JButton("acos");
    private final JButton atanButton = new JButton("atan");
    private final JButton sinhButton = new JButton("sinh");
    private final JButton coshButton = new JButton("cosh");
    private final JButton tanhButton = new JButton("tanh");
    private final JButton powerofn = new JButton("10^n");
    private final JButton logbutton = new JButton("log");
    private final JButton lnbutton = new JButton("ln");
    private final JButton absbutton = new JButton("abs");
    private final JButton exitbutton = new JButton("EXIT");

    //------------container variables---------------
    private final JTextField textDisplay = new JTextField();//result displaying screen
    private final JTextField textInput = new JTextField();
    private String s = "";
    private String dis = "";//Input string
    private boolean plusS = true;//Is the sign of the operand is plus
    //is there is decimal point in the operands
    private boolean decimalS = false;
    private boolean operationS = false;
    private double number1 = 0;// 1st operand
    private char operation = ' ';// Operation
    static Color windowColor = new Color(110, 119, 129);//Color of container window


    //==================Default Constructor to Design the layout of the calculator===========================
    public MyCalculator()
    {
        setBackground(windowColor);
        setLayout(null);
        JPanel scr = new JPanel(); // The screen that display the input
        JPanel scr2 = new JPanel(); // The screen that show the result
        JPanel scr3 = new JPanel(); // The keypad that contain the common keys
        JPanel scr4 = new JPanel(); // The keypad that contains the scientific keys.

        //---------------------Fonts & Colors------------------------
        Font f = new Font("Times New Roman", Font.BOLD, 35);//Font for displaying result
        Font f1 = new Font("Times New Roman", Font.PLAIN, 20);//Font for key character
        Font f2 = new Font("Times New Roman", Font.PLAIN, 15);//Font for key character

        Color cR = new Color(91, 178, 91);
        Color cR1 = new Color(212, 212, 212);
        Color cR2 = new Color(63, 132, 243);
        Color cR3 = new Color(224, 67, 67);
        Color cR4 = new Color(247, 247, 247);

        //===========================Designing the Result screen of the calculator ===========================
        add(scr).setBounds(0, 0, 343, 30);
        scr.add(textInput);
        scr.setLayout(null);
        textInput.setBounds(0, 0, 343, 30);
        textInput.setHorizontalAlignment(JTextField.LEFT);
        textInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textInput.setText("0");
        textInput.setEditable(false);
        textInput.setBackground(cR);
        textInput.setForeground(Color.BLACK);
        //===========================Designing the Result screen of the calculator ===========================
        add(scr2).setBounds(0, 30, 343, 50);
        scr2.add(textDisplay);
        scr2.setLayout(null);
        textDisplay.setBounds(0, 0, 343, 50);
        textDisplay.setHorizontalAlignment(JTextField.RIGHT);
        textDisplay.setFont(f);
        textDisplay.setText("0");
        textDisplay.setEditable(false);
        textDisplay.setBackground(cR);
        textDisplay.setForeground(Color.BLACK);

        //==========================Designing the keypad1(Common Keys) of the calculator =====================
        add(scr3).setBounds(0, 100, 343, 190);
        scr3.setLayout(null);
        scr3.setBackground(windowColor);

        //------------setting font, color and style of the common keys-------
        numOne.setFont(f1);	numOne.setBackground(cR1);	numOne.setFocusable(false);
        numTwo.setFont(f1);	numTwo.setBackground(cR1);	numTwo.setFocusable(false);
        numThree.setFont(f1);	numThree.setBackground(cR1);	numThree.setFocusable(false);
        numFour.setFont(f1);	numFour.setBackground(cR1);	numFour.setFocusable(false);
        numFive.setFont(f1);	numFive.setBackground(cR1);	numFive.setFocusable(false);
        numSix.setFont(f1);	numSix.setBackground(cR1);	numSix.setFocusable(false);
        numSeven.setFont(f1);	numSeven.setBackground(cR1);	numSeven.setFocusable(false);
        numEight.setFont(f1);	numEight.setBackground(cR1);	numEight.setFocusable(false);
        numNine.setFont(f1);	numNine.setBackground(cR1);	numNine.setFocusable(false);
        numZero.setFont(f1);	numZero.setBackground(cR1);	numZero.setFocusable(false);
        add.setFont(f1);	add.setBackground(cR4);	add.setFocusable(false);
        subtract.setFont(f1);	subtract.setBackground(cR4);	subtract.setFocusable(false);
        multiply.setFont(f1);	multiply.setBackground(cR4);	multiply.setFocusable(false);
        divide.setFont(f1);	divide.setBackground(cR4);	divide.setFocusable(false);
        decimal.setFont(f1);	decimal.setBackground(cR1);	decimal.setFocusable(false);
        equalSign.setFont(new Font("Times New Roman", Font.PLAIN, 40));	equalSign.setBackground(cR2);	equalSign.setFocusable(false);
        clear.setFont(f1);	clear.setBackground(cR3);	clear.setFocusable(false);
        squared.setFont(f1);	squared.setBackground(cR4);	squared.setFocusable(false);
        squareRoot.setFont(f1);	squareRoot.setBackground(cR4);	squareRoot.setFocusable(false);
        cubeSign.setFont(f1);	cubeSign.setBackground(cR4);	cubeSign.setFocusable(false);
        percent.setFont(f1);	percent.setBackground(cR4);	percent.setFocusable(false);
        modulo.setFont(new Font("Times New Roman", Font.PLAIN, 10));  modulo.setBackground(cR4);	modulo.setFocusable(false);
        reciprocal.setFont(f2);	reciprocal.setBackground(cR4);	reciprocal.setFocusable(false);
        negative.setFont(f1);	negative.setBackground(cR1);	negative.setFocusable(false);

        //-----------------------------placing the common keys-------------------------------------
        // 1st row
        scr3.add(clear).setBounds(280, 0, 54, 38);
        // 2nd row
        scr3.add(numSeven).setBounds(10, 38, 54, 38);scr3.add(numEight).setBounds(64, 38, 54, 38);scr3.add(numNine).setBounds(118, 38, 54, 38);
        scr3.add(multiply).setBounds(172, 38, 54, 38);scr3.add(divide).setBounds(226, 38, 54, 38);scr3.add(squared).setBounds(280, 38, 54, 38);
        // 3rd row
        scr3.add(numFour).setBounds(10, 76, 54, 38);scr3.add(numFive).setBounds(64, 76, 54, 38);scr3.add(numSix).setBounds(118, 76, 54, 38);
        scr3.add(add).setBounds(172, 76, 54, 38);scr3.add(subtract).setBounds(226, 76, 54, 38);scr3.add(cubeSign).setBounds(280, 76, 54, 38);
        // 4th row
        scr3.add(numOne).setBounds(10, 114, 54, 38);scr3.add(numTwo).setBounds(64, 114, 54, 38);scr3.add(numThree).setBounds(118, 114, 54, 38);
        scr3.add(equalSign).setBounds(172, 114, 108, 38);scr3.add(modulo).setBounds(280, 114, 54, 38);
        // 5th row
        scr3.add(numZero).setBounds(10, 152, 54, 38);scr3.add(decimal).setBounds(64, 152, 54, 38);scr3.add(negative).setBounds(118, 152, 54, 38);
        scr3.add(reciprocal).setBounds(172, 152, 54, 38);scr3.add(percent).setBounds(226, 152, 54, 38);scr3.add(squareRoot).setBounds(280, 152, 54, 38);


        //==========================Designing the keypad2(scientific Keys) of the calculator =====================

        add(scr4).setBounds(0, 310, 343, 145);
        scr4.setLayout(null);
        scr4.setBackground(windowColor);

        //----------------------copyright tag-------------------------------------------------------


        //-----------------------------placing the Scientific keys-------------------------------------
        //	1st row
        scr4.add(sinButton).setBounds(10, 0, 65, 38);scr4.add(cosButton).setBounds(75, 0, 65, 38);scr4.add(tanButton).setBounds(140, 0, 65, 38);
        scr4.add(logbutton).setBounds(205, 0, 65, 38);scr4.add(lnbutton).setBounds(270, 0, 64, 38);
        //	2nd row
        scr4.add(asinButton).setBounds(10, 38, 65, 38);scr4.add(acosButton).setBounds(75, 38, 65, 38);scr4.add(atanButton).setBounds(140, 38, 65, 38);
        scr4.add(powerofn).setBounds(205, 38, 65, 38);scr4.add(absbutton).setBounds(270, 38, 64, 38);
        //	3rd row
        scr4.add(sinhButton).setBounds(10, 76, 65, 38);scr4.add(coshButton).setBounds(75, 76, 65, 38);scr4.add(tanhButton).setBounds(140, 76, 65, 38);
        scr4.add(exitbutton).setBounds(205, 76, 130, 38);

        //------------setting font, color and style of the common keys-------
        sinButton.setFont(f1);	sinButton.setBackground(cR4);	sinButton.setFocusable(false);
        cosButton.setFont(f1);	cosButton.setBackground(cR4);	cosButton.setFocusable(false);
        tanButton.setFont(f1);	tanButton.setBackground(cR4);	tanButton.setFocusable(false);
        asinButton.setFont(f2);	asinButton.setBackground(cR4);	asinButton.setFocusable(false);
        acosButton.setFont(f2);	acosButton.setBackground(cR4);	acosButton.setFocusable(false);
        atanButton.setFont(f2);	atanButton.setBackground(cR4);	atanButton.setFocusable(false);
        sinhButton.setFont(f2);	sinhButton.setBackground(cR4);	sinhButton.setFocusable(false);
        coshButton.setFont(f2);	coshButton.setBackground(cR4);	coshButton.setFocusable(false);
        tanhButton.setFont(f2);	tanhButton.setBackground(cR4);	tanhButton.setFocusable(false);
        logbutton.setFont(f1);	logbutton.setBackground(cR4);	logbutton.setFocusable(false);
        lnbutton.setFont(f1);	lnbutton.setBackground(cR4);		lnbutton.setFocusable(false);
        absbutton.setFont(f1);	absbutton.setBackground(cR4);	absbutton.setFocusable(false);
        exitbutton.setFont(f1);	exitbutton.setBackground(cR3);		exitbutton.setFocusable(false);
        powerofn.setFont(f2);	powerofn.setBackground(cR4);	powerofn.setFocusable(false);

        // ======================================Adding actionListener =======================================
        //common keys
        numOne.addActionListener(this);
        numTwo.addActionListener(this);
        numThree.addActionListener(this);
        numFour.addActionListener(this);
        numFive.addActionListener(this);
        numSix.addActionListener(this);
        numSeven.addActionListener(this);
        numEight.addActionListener(this);
        numNine.addActionListener(this);
        numZero.addActionListener(this);
        add.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        decimal.addActionListener(this);
        equalSign.addActionListener(this);
        clear.addActionListener(this);
        squared.addActionListener(this);
        squareRoot.addActionListener(this);
        cubeSign.addActionListener(this);
        percent.addActionListener(this);
        modulo.addActionListener(this);
        reciprocal.addActionListener(this);
        negative.addActionListener(this);
        //scientific keys
        sinButton.addActionListener(this);
        cosButton.addActionListener(this);
        tanButton.addActionListener(this);
        asinButton.addActionListener(this);
        acosButton.addActionListener(this);
        atanButton.addActionListener(this);
        sinhButton.addActionListener(this);
        coshButton.addActionListener(this);
        tanhButton.addActionListener(this);
        powerofn.addActionListener(this);
        logbutton.addActionListener(this);
        lnbutton.addActionListener(this);
        absbutton.addActionListener(this);
        exitbutton.addActionListener(this);

    }
    //=================================Main method=============================
    public static void main(String[] CHAND)
    {
        MyCalculator frame = new MyCalculator();
        frame.setTitle("CI- Calculator");
        frame.setSize(350, 500);
        frame.getContentPane().setBackground(windowColor);
        frame.setLocationRelativeTo(null);
        //frame.setMaximizedBounds(new Rectangle(300, 200));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //==============================ActionListener of All keys ===========================
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // 2nd operand
        double number2;
        // Result
        double result;
        if (e.getSource() == numOne)
        {
            if(operation == '=')
            {
                dis = "1";
                s = "1";
                textInput.setText(s);
                operation = ' ';
            }
            else
            {
                dis = dis + "1";
                s += "1";
                textInput.setText(s);
            }
        }
        else if (e.getSource() == numTwo)
        {
            if(operation == '=')
            {
                dis = "2";
                s = "2";
                textInput.setText(s);
                operation = ' ';
            }
            else
            {
                dis = dis + "2";
                s += "2";
                textInput.setText(s);
            }
        }
        else if (e.getSource() == numThree)
        {
            if(operation == '=')
            {
                dis = "3";
                s = "3";
                textInput.setText(s);
                operation = ' ';
            }
            else
            {
                dis = dis + "3";
                s += "3";
                textInput.setText(s);
            }
        }
        else if (e.getSource() == numFour)
        {
            if(operation == '=')
            {
                dis = "4";
                s = "4";
                textInput.setText(s);
                operation = ' ';
            }
            else
            {
                dis = dis + "4";
                s += "4";
                textInput.setText(s);
            }
        }
        else if (e.getSource() == numFive)
        {
            if(operation == '=')
            {
                dis = "5";
                s = "5";
                textInput.setText(s);
                operation = ' ';
            }
            else
            {
                dis = dis + "5";
                s += "5";
                textInput.setText(s);
            }
        }
        else if (e.getSource() == numSix)
        {
            if(operation == '=')
            {
                dis = "6";
                s = "6";
                textInput.setText(s);
                operation = ' ';
            }
            else
            {
                dis = dis + "6";
                s += "6";
                textInput.setText(s);
            }
        }
        else if (e.getSource() == numSeven)
        {
            if(operation == '=')
            {
                dis = "7";
                s = "7";
                textInput.setText(s);
                operation = ' ';
            }
            else
            {
                dis = dis + "7";
                s += "7";
                textInput.setText(s);
            }
        }
        else if (e.getSource() == numEight)
        {
            if(operation == '=')
            {
                dis = "8";
                s = "8";
                textInput.setText(s);
                operation = ' ';
            }
            else
            {
                dis = dis + "8";
                s += "8";
                textInput.setText(s);
            }
        }
        else if (e.getSource() == numNine)
        {
            if(operation == '=')
            {
                dis = "9";
                s = "9";
                textInput.setText(s);
                operation = ' ';
            }
            else
            {
                dis = dis + "9";
                s += "9";
                textInput.setText(s);
            }
        }
        else if (e.getSource() == numZero)
        {
            if(dis.equals(""))//zero at first
            {
                dis = "0";
            }
            else
            {
                dis = dis + "0";
            }
            s += "0";
            textInput.setText(s);
        }
        else if (e.getSource() == decimal) ///when bPoint is clicked
        {
            if(dis.equals(""))//bPoint at starting of a number
            {
                dis = "0.";
                s += "0.";
                textInput.setText(s);
            }
            else if(!decimalS)//when there is no bPoint till now then just add the bPoint
            {
                dis = dis + ".";
                s += ".";
                textInput.setText(s);
            }
            decimalS = true;//when the bPoint button is clicked once set the bPoint flag to true
        }
        else if(e.getSource() == negative && !dis.equals("") && !operationS)//plus minus(sign) button
        {
            if(plusS)
            {
                dis = "-" + dis;
                s = dis;
                textInput.setText(s);
                plusS = false;
            }
            else
            {
                dis = dis.substring(1);
                s = dis.substring(1);
                textInput.setText(s);
                plusS = true;
            }
        }
        else if (e.getSource() == add && (!dis.equals("") || operation == '=')) // + button is clicked and input is not empty
        {
            if(!operationS)//to check if plus without number1
            {
                number1 = Double.parseDouble(dis);
                dis = "";
                operation = '+';
                plusS = true;
                s += " + ";
                textInput.setText(s);
                if(decimalS)//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    textDisplay.setText(""+number1);
                }
                else {
                    textDisplay.setText(""+(long)number1);
                }
            }
            else if(operation != '=')
            {
                number2 = Double.parseDouble(dis);

                if(operation == '+')
                {
                    result = number1 + number2;
                }
                else if(operation == '-')
                {
                    result = number1 - number2;
                }
                else if(operation == '*')
                {
                    result = number1 * number2;
                }
                else if(operation == '/')
                {
                    result = number1 / number2;
                }
                else if(operation == '%')
                {
                    result = number1 % number2;
                }
                else
                {
                    result = number2;
                }
                String temp;
                if(decimalS || operation == '/')//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    textDisplay.setText(""+ result);
                    temp = ""+ result;
                }
                else {
                    textDisplay.setText(""+(long) result);
                    temp = ""+(long) result;
                }
                operation = '+';
                dis = "";
                number1 = result;
                plusS = true;
                decimalS = false;
                operationS = true;
                s += " + ";
                textInput.setText(s);
                s = temp + " + ";
            }
            else {
                dis = "";
                operation = '+';
                plusS = true;
                s += " + ";
                textInput.setText(s);
            }
            operationS = true;
        }
        else if (e.getSource() == subtract && (!dis.equals("") || operation == '='))  // - button is clicked and input is not empty
        {
            if(!operationS)//to check if plus without number1
            {
                number1 = Double.parseDouble(dis);
                dis = "";
                operation = '-';
                plusS = true;
                s += " - ";
                textInput.setText(s);
                if(decimalS)//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    textDisplay.setText(""+number1);
                }
                else {
                    textDisplay.setText(""+(long)number1);
                }
            }
            else if(operation != '=')
            {
                number2 = Double.parseDouble(dis);

                if(operation == '+')
                {
                    result = number1 + number2;
                }
                else if(operation == '-')
                {
                    result = number1 - number2;
                }
                else if(operation == '*')
                {
                    result = number1 * number2;
                }
                else if(operation == '/')
                {
                    result = number1 / number2;
                }
                else if(operation == '%')
                {
                    result = number1 % number2;
                }
                else
                {
                    result = number2;
                }
                String temp;
                if(decimalS || operation == '/')//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    textDisplay.setText(""+ result);
                    temp = ""+ result;
                }
                else {
                    textDisplay.setText(""+(long) result);
                    temp = ""+(long) result;
                }
                operation = '-';
                dis = "";
                number1 = result;
                plusS = true;
                decimalS = false;
                operationS = true;
                s += " - ";
                textInput.setText(s);
                s = temp + " + ";
            }
            else {
                dis = "";
                operation = '-';
                plusS = true;
                s += " - ";
                textInput.setText(s);
            }
            operationS = true;
        }
        else if (e.getSource() == multiply && (!dis.equals("") || operation == '='))  // * button is clicked and input is not empty
        {
            if(!operationS)//to check if plus without number1
            {
                number1 = Double.parseDouble(dis);
                dis = "";
                operation = '*';
                plusS = true;
                s += " × ";
                textInput.setText(s);
                if(decimalS)//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    textDisplay.setText(""+number1);
                }
                else {
                    textDisplay.setText(""+(long)number1);
                }
            }
            else if(operation != '=')
            {
                number2 = Double.parseDouble(dis);

                if(operation == '+')
                {
                    result = number1 + number2;
                }
                else if(operation == '-')
                {
                    result = number1 - number2;
                }
                else if(operation == '*')
                {
                    result = number1 * number2;
                }
                else if(operation == '/')
                {
                    result = number1 / number2;
                }
                else if(operation == '%')
                {
                    result = number1 % number2;
                }
                else
                {
                    result = number2;
                }
                String temp;
                if(decimalS || operation == '/')//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    textDisplay.setText(""+ result);
                    temp = ""+ result;
                }
                else {
                    textDisplay.setText(""+(long) result);
                    temp = ""+(long) result;
                }
                operation = '*';
                dis = "";
                number1 = result;
                plusS = true;
                decimalS = false;
                operationS = true;
                s += " × ";
                textInput.setText(s);
                s = temp + " × ";
            }
            else {
                dis = "";
                operation = '*';
                plusS = true;
                s += " × ";
                textInput.setText(s);
            }
            operationS = true;
        }
        else if (e.getSource() == divide && (!dis.equals("") || operation == '='))  // bDivision button is clicked and input is not empty
        {
            if(!operationS)//to check if plus without number1
            {
                number1 = Double.parseDouble(dis);
                dis = "";
                operation = '/';
                plusS = true;
                s += " / ";
                textInput.setText(s);
                if(decimalS)//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    textDisplay.setText(""+number1);
                }
                else {
                    textDisplay.setText(""+(long)number1);
                }
            }
            else if(operation != '=')
            {
                number2 = Double.parseDouble(dis);

                if(operation == '+')
                {
                    result = number1 + number2;
                }
                else if(operation == '-')
                {
                    result = number1 - number2;
                }
                else if(operation == '*')
                {
                    result = number1 * number2;
                }
                else if(operation == '/')
                {
                    result = number1 / number2;
                }
                else if(operation == '%')
                {
                    result = number1 % number2;
                }
                else
                {
                    result = number2;
                }
                String temp;
                if(decimalS || operation == '/')//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    textDisplay.setText(""+ result);
                    temp = ""+ result;
                }
                else {
                    textDisplay.setText(""+(long) result);
                    temp = ""+(long) result;
                }
                operation = '*';
                dis = "";
                number1 = result;
                plusS = true;
                decimalS = false;
                operationS = true;
                s += " / ";
                textInput.setText(s);
                s = temp + " / ";
            }
            else {
                dis = "";
                operation = '/';
                plusS = true;
                s += " / ";
                textInput.setText(s);
            }
            operationS = true;
        }
        else if (e.getSource() == modulo && (!dis.equals("") || operation == '='))//Modules button
        {
            if(!operationS)//to check if plus without number1
            {
                number1 = Double.parseDouble(dis);
                dis = "";
                operation = '%';
                plusS = true;
                s += " mod ";
                textInput.setText(s);
                if(decimalS)//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    textDisplay.setText(""+number1);
                }
                else {
                    textDisplay.setText(""+(long)number1);
                }
            }
            else if(operation != '=')
            {
                number2 = Double.parseDouble(dis);

                if(operation == '+')
                {
                    result = number1 + number2;
                }
                else if(operation == '-')
                {
                    result = number1 - number2;
                }
                else if(operation == '*')
                {
                    result = number1 * number2;
                }
                else if(operation == '/')
                {
                    result = number1 / number2;
                }
                else if(operation == '%')
                {
                    result = number1 % number2;
                }
                else
                {
                    result = number2;
                }
                String temp;
                if(decimalS || operation == '/')//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    textDisplay.setText(""+ result);
                    temp = ""+ result;
                }
                else {
                    textDisplay.setText(""+(long) result);
                    temp = ""+(long) result;
                }
                operation = '%';
                dis = "";
                number1 = result;
                plusS = true;
                decimalS = false;
                operationS = true;
                s += " mod ";
                textInput.setText(s);
                s = temp + " * ";
            }
            else {
                dis = "";
                operation = '%';
                plusS = true;
                s += " mod ";
                textInput.setText(s);
            }
            operationS = true;
        }
        else if (e.getSource() == equalSign && !dis.equals(""))//when bEqual button is clicked and the input is not empty
        {
            number2 = Double.parseDouble(dis);

            if(operation == '+')
            {
                result = number1 + number2;
            }
            else if(operation == '-')
            {
                result = number1 - number2;
            }
            else if(operation == '*')
            {
                result = number1 * number2;
            }
            else if(operation == '/')
            {
                result = number1 / number2;
            }
            else if(operation == '%')
            {
                result = number1 % number2;
            }
            else
            {
                result = number2;
            }
            String temp;
            if(decimalS || operation == '/')//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
            {
                textDisplay.setText(""+ result);
                temp = ""+ result;
            }
            else {
                textDisplay.setText(""+(long) result);
                temp = ""+(long) result;
            }
            dis = "";
            number1 = result;
            plusS = true;
            decimalS = false;
            operationS = true;
            s += " = ";
            textInput.setText(s);
            s = temp;
            operation = '=';
        }
        else if (e.getSource() == clear)//Clear button
        {
            number1 = 0;
            dis = "";
            operation = ' ';
            textDisplay.setText("0");
            decimalS = false;
            plusS = true;
            operationS = false;
            s = "";
            textInput.setText("0");
        }
        else if (e.getSource() == squared && !dis.equals(""))//Square button
        {
            number1 = Double.parseDouble(dis);
            result = Math.pow(number1, 2);
            String temp;
            if(!decimalS)
            {
                textDisplay.setText(""+(long) result);
                temp = ""+(long) result;
            }
            else
            {
                textDisplay.setText(""+ result);
                temp = ""+ result;
            }
            s += "^2 = ";
            textInput.setText(s);
            s = temp;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = false;
            operationS = true;
            plusS = true;
        }
        else if (e.getSource() == squareRoot && !dis.equals(""))//root button
        {
            number1 = Double.parseDouble(dis);
            result = Math.sqrt(number1);
            s =  "√" + s;
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if (e.getSource() == cubeSign && !dis.equals("")) //Cube button
        {
            number1 = Double.parseDouble(dis);
            result = Math.pow(number1, 3);
            String temp;
            if(!decimalS)
            {
                textDisplay.setText(""+(long) result);
                temp = ""+(long) result;
            }
            else
            {
                textDisplay.setText(""+ result);
                temp = ""+ result;
            }
            s +="^3 = ";
            textInput.setText(s);
            s = temp;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = false;
            operationS = true;
            plusS = true;

        }
        else if (e.getSource() == reciprocal && !dis.equals(""))// 1/n button
        {
            number1 = Double.parseDouble(dis);
            result = 1 / number1;
            if(decimalS)
            {
                s = "1 / " + number1;
            }
            else
            {
                s = "1 / " + (long)number1;
            }
            textInput.setText(s);
            textDisplay.setText(""+ result);
            dis = "";
            s = ""+ result;
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == percent && !dis.equals("") && operation=='*')// % button is pressed
        {
            number2 = Double.parseDouble(dis);
            result = number1 * (number2 / 100);
            s = number1+" × "+ number2 +"%";
            textInput.setText(s);
            textDisplay.setText(""+ result);
            dis = "";
            number1 = result;
            operation = '=';
            plusS = true;
            operationS = true;
            decimalS = true;
            s = ""+ result;
        }
        else if(e.getSource() == sinButton && !dis.equals(""))//sin function
        {
            number1 = Double.parseDouble(dis);
            if(number1 == 30)
            {
                result = Math.sin(Math.toRadians(number1)) + 0.0000000000000001;
            }
            else
            {
                result = Math.sin(Math.toRadians(number1));
            }
            s =  "sin("+ s +")";
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == cosButton && !dis.equals(""))//cosine function
        {
            number1 = Double.parseDouble(dis);
            if(number1 == 60)
            {
                result = Math.cos(Math.toRadians(number1)) - 0.0000000000000001;
            }
            else if (number1 == 90)
            {
                result = 0;
            }
            else
            {
                result = Math.cos(Math.toRadians(number1));
            }
            s =  "cos("+ s +")";
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == tanButton && !dis.equals(""))//tan function
        {
            number1 = Double.parseDouble(dis);
            if(number1 == 45)
            {
                result = Math.tan(Math.toRadians(number1)) + 0.0000000000000001;
            }
            else if(number1 == 90)
            {
                result = 0;
                textDisplay.setText("Invalid");
            }
            else
            {
                result = Math.tan(Math.toRadians(number1));
            }
            s =  "tan("+ s +")";
            textInput.setText(s);
            if(number1 != 90)
            {
                textDisplay.setText(""+ result);
            }
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == sinhButton && !dis.equals(""))//sinh function
        {
            number1 = Double.parseDouble(dis);
            result = Math.sinh(Math.toRadians(number1));
            s =  "sinh("+ s +")";
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == coshButton && !dis.equals(""))//cosh function
        {
            number1 = Double.parseDouble(dis);
            result = Math.cosh(Math.toRadians(number1));
            s =  "cosh("+ s +")";
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == tanhButton && !dis.equals(""))//tanh function
        {
            number1 = Double.parseDouble(dis);
            result = Math.tanh(Math.toRadians(number1));
            s =  "tanH("+ s +")";
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == asinButton && !dis.equals(""))//asin function
        {
            number1 = Double.parseDouble(dis);
            result = Math.asin(Math.toRadians(number1));
            s =  "asin("+ s +")";
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == acosButton && !dis.equals(""))//acos function
        {
            number1 = Double.parseDouble(dis);
            result = Math.acos(Math.toRadians(number1));
            s =  "acos("+ s +")";
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == atanButton && !dis.equals(""))//atan function
        {
            number1 = Double.parseDouble(dis);
            result = Math.atan(Math.toRadians(number1));
            s =  "atan("+ s +")";
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == logbutton && !dis.equals(""))//log function
        {
            number1 = Double.parseDouble(dis);
            result = Math.log10(number1);
            s =  "log"+ s;
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == lnbutton && !dis.equals(""))//ln function
        {
            number1 = Double.parseDouble(dis);
            result = Math.log(number1);
            s =  "ln"+ s;
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == absbutton && !dis.equals(""))//abs function
        {
            number1 = Double.parseDouble(dis);
            result = Math.abs(number1);
            s =  "abs("+ s +")";
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == powerofn && !dis.equals(""))//power of ten function
        {
            number1 = Double.parseDouble(dis);
            result = Math.pow(10, number1);
            s =  "10^"+ s;
            textInput.setText(s);
            textDisplay.setText(""+ result);
            s = ""+ result;
            dis = "";
            number1 = result;
            operation = '=';
            decimalS = true;
            operationS = true;
            plusS = true;
        }
        else if(e.getSource() == exitbutton)//exit button
        {
            System.exit(0);
        }
    }
}
