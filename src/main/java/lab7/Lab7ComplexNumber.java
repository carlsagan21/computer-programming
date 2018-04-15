package lab7;

import java.util.Scanner;

class ComplexNumber {

  private int real;
  private int imaginary;

  ComplexNumber(int real, int imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }

  static void printCNSum(ComplexNumber first, ComplexNumber second) {
    System.out.println(
        "Sum : " + (first.real + second.real) + "+" + (first.imaginary + second.imaginary) + "i");
  }

  static void printCNDifference(ComplexNumber first, ComplexNumber second) {
    int diffOfImaginary = first.imaginary - second.imaginary;

    System.out.println(
        "Difference : " + (first.real - second.real) + (diffOfImaginary >= 0 ? "+" + diffOfImaginary
            : diffOfImaginary)
            + "i");
  }

}

public class Lab7ComplexNumber {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Input the real part of first number : ");
    int firstReal = sc.nextInt();
    System.out.print("input the imaginary of first number : ");
    int firstImaginary = sc.nextInt();
    ComplexNumber firstCN = new ComplexNumber(firstReal, firstImaginary);

    System.out.print("Input the real part of second number : ");
    int secondReal = sc.nextInt();
    System.out.print("input the imaginary of second number : ");
    int secondImaginary = sc.nextInt();
    ComplexNumber secondCN = new ComplexNumber(secondReal, secondImaginary);

    ComplexNumber.printCNSum(firstCN, secondCN);
    ComplexNumber.printCNDifference(firstCN, secondCN);

  }

}
