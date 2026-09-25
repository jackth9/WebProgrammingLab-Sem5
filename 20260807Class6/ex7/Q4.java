import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Q4 extends JFrame {
//CurrencyConverter
    private JTextField amountField;
    private JComboBox<String> fromCurrencyBox;
    private JComboBox<String> toCurrencyBox;
    private JLabel resultLabel;
    private JButton convertButton;

    private Map<String, Double> ratesToUSD = new HashMap<>();

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setLayout(new FlowLayout());
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ratesToUSD.put("USD", 1.0);
        ratesToUSD.put("EUR", 1.08);
        ratesToUSD.put("GBP", 1.27);
        ratesToUSD.put("INR", 0.012);
        ratesToUSD.put("JPY", 0.0064);

        String[] currencies = {"USD", "EUR", "GBP", "INR", "JPY"};

        amountField = new JTextField(10);
        fromCurrencyBox = new JComboBox<>(currencies);
        toCurrencyBox = new JComboBox<>(currencies);
        convertButton = new JButton("Convert");
        resultLabel = new JLabel("Converted Amount: ");

        add(new JLabel("Amount:"));
        add(amountField);
        add(new JLabel("From:"));
        add(fromCurrencyBox);
        add(new JLabel("To:"));
        add(toCurrencyBox);
        add(convertButton);
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String from = (String) fromCurrencyBox.getSelectedItem();
                    String to = (String) toCurrencyBox.getSelectedItem();

                    double amountInUSD = amount * ratesToUSD.get(from);
                    double convertedAmount = amountInUSD / ratesToUSD.get(to);

                    resultLabel.setText(String.format("Converted Amount: %.2f %s", convertedAmount, to));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CurrencyConverter.this, "Please enter a valid numeric amount.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}