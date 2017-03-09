package com.hack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class Volumes {

	public static void main(String[] args) {
		try {
			Calculate cal = new Calculate();
			int t = cal.get_int_val();
			while (t-- > 0) {
				double volume = 0.0;
				int ch = cal.get_int_val();
				if (ch == 1) {
					int a = cal.get_int_val();
					volume = Calculate.do_calc().get_volume(a);
				} else if (ch == 2) {
					int l = cal.get_int_val();
					int b = cal.get_int_val();
					int h = cal.get_int_val();
					volume = Calculate.do_calc().get_volume(l, b, h);

				} else if (ch == 3) {
					double r = cal.get_double_val();
					volume = Calculate.do_calc().get_volume(r);

				} else if (ch == 4) {
					double r = cal.get_double_val();
					double h = cal.get_double_val();
					volume = Calculate.do_calc().get_volume(r, h);

				}
				cal.output.display(volume);
			}

		} catch (NumberFormatException e) {
			System.out.print(e);
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of main
}

class Calculate{
	Scanner sc = new Scanner(System.in);
	static Calc calc = new Calc();
	static Calc output = calc;
	public int get_int_val() throws IOException {
		return sc.nextInt();		
	}

	public static Calc do_calc() {
		return calc;
	}

	public double get_double_val() throws IOException {
		return sc.nextDouble();
	}
	
}
class Calc{

	public double get_volume(int a) {
		return Math.pow(a, 3);
	}

	public void display(double volume) {
		if(volume <= 0){
			throw new NumberFormatException("All values must be positive");
		}else{
			System.out.println(volume);
		}
		
	}

	public double get_volume(double r, double h) {
		return Math.PI * Math.pow(r, 2) * h;
	}

	public double get_volume(double r) {
		return 4 * Math.PI * Math.pow(r, 3) / 6;
	}

	public double get_volume(int l, int b, int h) {
		return l * b * h;
	}
	
}