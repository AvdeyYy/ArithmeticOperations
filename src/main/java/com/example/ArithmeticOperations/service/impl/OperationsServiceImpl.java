package com.example.ArithmeticOperations.service.impl;

import com.example.ArithmeticOperations.service.OperationsService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;


@Service
@Data
public class OperationsServiceImpl implements OperationsService {

    /*
     *Method for adding two or more numbers
     */
    @Override
    public Object sum(String line) {
        try {
            return Arrays.stream(new String(line.getBytes(), StandardCharsets.UTF_8).split(" "))
                    .mapToInt(Integer::parseInt)
                    .sum();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "Неправильный формат ввода, введите целое число";
        }
    }

    /*
     *Method for multiplying two or more numbers
     */
    @Override
    public Object multiply(String line) {
        try {

            return Arrays.stream(new String(line.getBytes(), StandardCharsets.UTF_8).split(" "))
                    .mapToInt(Integer::parseInt)
                    .reduce((d1, d2) -> d1 * d2).getAsInt();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "Неправильный формат ввода, попробуйте еще раз";
        }
    }

    /*
     *Method for multiplying the first two numbers and adding the third
     */
    @Override
    public Object multiplyAndSum(String line) {
        int result = 1;
        try {
            String[] lines = line.split(" ");
            for (int i = 0; i < lines.length; i++) {
                int temp = Integer.parseInt(lines[i]);
                if (i == 2) {
                    result += temp;
                    break;
                }
                result *= temp;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "Неправильный формат ввода, попробуйте еще раз";
        }
        return result;
    }


    /*
     *Method for adding numbers and dividing by their number
     */
    @Override
    public Object sumAndDivide(String line) {
        int result = 0;
        try {
            String[] lines = line.split(" ");
            for (int i = 0; i < lines.length; i++) {
                int temp = Integer.parseInt(lines[i]);
                result += temp;
            }
            result /= lines.length;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "Неправильный формат ввода, попробуйте еще раз";
        }
        return result;

    }

}
