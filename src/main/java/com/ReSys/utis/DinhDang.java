/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.utis;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class DinhDang {
    private static final DecimalFormat formatter;
    private static final DecimalFormat parser;

    static {
        // Cấu hình định dạng tiền tệ với dấu phân cách hàng nghìn là dấu chấm
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');

        formatter = new DecimalFormat("#,###", symbols);
        
        // Cấu hình phân tích tiền tệ, loại bỏ ký tự không cần thiết như dấu tiền tệ
        parser = new DecimalFormat("#,###", symbols);
    }

    // Định dạng số thành chuỗi tiền tệ
    public static String formatCurrency(double amount) {
        return formatter.format(amount); // Thêm ký hiệu tiền tệ nếu cần
    }

    // Phân tích chuỗi tiền tệ thành số
    public static double parseCurrency(String currency) throws NumberFormatException {
        try {
            // Loại bỏ ký hiệu tiền tệ nếu có
            String cleaned = currency.replace(" VND", "").replace(".", "");
            return parser.parse(cleaned).doubleValue();
        } catch (ParseException e) {
            throw new NumberFormatException("Định dạng tiền tệ không hợp lệ: " + currency);
        }
    }
}
