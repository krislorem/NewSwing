/**
 * @author Zhai Jinpei
 */
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class N extends JFrame {
    public static void main(String[] args) {
        new N();
    }

    private static final JButton[] jButtons = new JButton[24];
    private final JPanel jPanel1 = new JPanel();
    private final JPanel jPanel2 = new JPanel();
    private final JPanel jPanel3 = new JPanel();
    private final JPanel jPanel4 = new JPanel();
    private final JMenuBar jMenuBar = new JMenuBar();
    private static final JTextField jTextField = new JTextField("");
    private static final JTextField resultjtf = new JTextField("");
    private static double MS;
    private static double MP;
    private static double MM;
    private static String all = "";

    static void initialNUM(String s) {
        all += s;
        jTextField.setText(all);
    }

    static {
        JButton jButton0 = new JButton("0");
        jButton0.addActionListener(e -> initialNUM("0"));
        JButton jButton1 = new JButton("1");
        jButton1.addActionListener(e -> initialNUM("1"));
        JButton jButton2 = new JButton("2");
        jButton2.addActionListener(e -> initialNUM("2"));
        JButton jButton3 = new JButton("3");
        jButton3.addActionListener(e -> initialNUM("3"));
        JButton jButton4 = new JButton("4");
        jButton4.addActionListener(e -> initialNUM("4"));
        JButton jButton5 = new JButton("5");
        jButton5.addActionListener(e -> initialNUM("5"));
        JButton jButton6 = new JButton("6");
        jButton6.addActionListener(e -> initialNUM("6"));
        JButton jButton7 = new JButton("7");
        jButton7.addActionListener(e -> initialNUM("7"));
        JButton jButton8 = new JButton("8");
        jButton8.addActionListener(e -> initialNUM("8"));
        JButton jButton9 = new JButton("9");
        jButton9.addActionListener(e -> initialNUM("9"));
        JButton jButtonMINUS = new JButton("+/-");
        jButtonMINUS.addActionListener(e -> initialNUM("*-1"));
        JButton jButtonPERCENT = new JButton("%");
        jButtonPERCENT.addActionListener(e -> initialNUM("*0.01"));
        JButton jButtonADD = new JButton("+");
        jButtonADD.addActionListener(e -> initialNUM("+"));
        JButton jButtonSUBTRACT = new JButton("-");
        jButtonSUBTRACT.addActionListener(e -> initialNUM("-"));
        JButton jButtonMULTIPLY = new JButton("*");
        jButtonMULTIPLY.addActionListener(e -> initialNUM("*"));
        JButton jButtonDIVIDE = new JButton("/");
        jButtonDIVIDE.addActionListener(e -> initialNUM("/"));
        JButton jButtonCLEARALL = new JButton("C");
        jButtonCLEARALL.addActionListener(e -> {
            all = "";
            jTextField.setText(all);
            resultjtf.setText("");
        });
        JButton jButtonCLAERTEXTFIELD = new JButton("CE");
        jButtonCLAERTEXTFIELD.addActionListener(e -> {
            all = "";
            jTextField.setText(all);
        });
        JButton jButtonSQRT = new JButton("开方");
        jButtonSQRT.addActionListener(e -> initialNUM("√"));
        JButton jButtonRECIPROCAL = new JButton("倒数");
        jButtonRECIPROCAL.addActionListener(e -> initialNUM("R"));
        JButton jButtonQUARDRATIC = new JButton("平方");
        jButtonQUARDRATIC.addActionListener(e -> initialNUM("S"));
        JButton jButtonDELETE = new JButton("DEL");
        jButtonDELETE.addActionListener(e -> {
            if (all.length() > 0) all = new StringBuilder(all).delete(all.length() - 1, all.length()).toString();
            jTextField.setText(all);
        });
        JButton jButtonPOINT = new JButton(".");
        jButtonPOINT.addActionListener(e -> initialNUM("."));
        JButton jButtonEQUALS = new JButton("=");
        jButtonEQUALS.addActionListener(e -> {
            resultjtf.setText(String.valueOf(cal(all)));
        });
        jButtons[0] = jButtonPERCENT;
        jButtons[1] = jButtonCLAERTEXTFIELD;
        jButtons[2] = jButtonCLEARALL;
        jButtons[3] = jButtonDELETE;
        jButtons[4] = jButtonRECIPROCAL;
        jButtons[5] = jButtonQUARDRATIC;
        jButtons[6] = jButtonSQRT;
        jButtons[7] = jButtonDIVIDE;
        jButtons[8] = jButton7;
        jButtons[9] = jButton8;
        jButtons[10] = jButton9;
        jButtons[11] = jButtonMULTIPLY;
        jButtons[12] = jButton4;
        jButtons[13] = jButton5;
        jButtons[14] = jButton6;
        jButtons[15] = jButtonSUBTRACT;
        jButtons[16] = jButton1;
        jButtons[17] = jButton2;
        jButtons[18] = jButton3;
        jButtons[19] = jButtonADD;
        jButtons[20] = jButtonMINUS;
        jButtons[21] = jButton0;
        jButtons[22] = jButtonPOINT;
        jButtons[23] = jButtonEQUALS;
    }

    @SuppressWarnings("all")
    private static double cal(String a) {//√
        double[] n = new double[64];
        double[] m = new double[64];
        String[] o = new String[64];
        Arrays.fill(n, 0);
        Arrays.fill(n, 0);
        Arrays.fill(o, "");
        String t = "";
        double r = 0;
        int co = 0;
        try {
            for (int i = 0; i < a.length(); ++i) {
                String c = String.valueOf(a.charAt(i));
                String cc = "";
                if (i < a.length() - 1) {
                    cc = String.valueOf(a.charAt(i + 1));
                }
                if (c.equals(".") ||
                        c.equals("0") ||
                        c.equals("1") || c.equals("2") || c.equals("3") || c.equals("4") || c.equals("5") ||
                        c.equals("6") || c.equals("7") || c.equals("8") || c.equals("9")
                ) {
                    t += c;
                    n[co] = Double.parseDouble(t);
                } else {
                    if (cc.equals("-")) {
                        t = "-";
                        ++i;
                    } else t = "";
                    if (c.equals("R") || c.equals("S")) {
                        o[++co] = String.valueOf(c);
                    } else {
                        ++co;
                        o[co++] = String.valueOf(c);
                    }
                }
            }
            int f = 0;
            int w = 0;
            for (int i = 0; i < n.length; i++) {
                if (o[i].equals("√")) {
                    int j;
                    for (j = i; j < n.length; ++j) {
                        if (o[j].equals("√")) {
                            ++w;
                            o[j] = "";
                            continue;
                        } else break;
                    }
                    n[j] = Math.pow(n[j], Math.pow(0.5, w));
                    m[j] = n[j];
                }
            }
            int z = 0;
            for (int i = 0; i < n.length; i++) {
                if (o[i].equals("S")) {
                    int j;
                    for (j = i; j < n.length; j++) {
                        if (o[j].equals("S")) {
                            o[j] = "";
                            ++z;
                            continue;
                        } else break;
                    }
                    n[i - 1] = Math.pow(n[i - 1], Math.pow(2, z));
                    m[i - 1] = n[i - 1];
                }
            }
            int x;
            double l;
            for (int i = 0; i < n.length; i++) {
                if (o[i].equals("R")) {
                    int j;
                    x = i;
                    l = n[x - 1];
                    for (j = i; j < n.length; ++j) {
                        if (o[j].equals("R")) {
                            o[j] = "";
                            continue;
                        } else break;
                    }
                    int p = j - i;
                    if (p % 2 == 1) n[x - 1] = 1 / l;
                    else n[x - 1] = l;
                    m[x - 1] = n[x - 1];
                }
            }
            for (int i = 0; i < n.length; i++) {
                if (o[i].equals("*") || o[i].equals("/")) {
                    int j = i;
                    do {
                        if (o[j].equals("*")) {
                            int k;
                            int v;
                            for (k = j + 1; k < n.length; k++) {
                                if (n[k] == 0) continue;
                                else break;
                            }
                            for (v = j - 1; v > 0; v--) {
                                if (n[v] == 0) continue;
                                else break;
                            }
                            n[k] *= n[v];
                            n[v] = 0;
                            o[j] = "";
                            ++j;
                        }
                        if (o[j].equals("/")) {
                            int k;
                            int v;
                            for (k = j + 1; k < n.length; k++) {
                                if (n[k] == 0) continue;
                                else break;
                            }
                            for (v = j - 1; v > 0; v--) {
                                if (n[v] == 0) continue;
                                else break;
                            }
                            n[k] = n[v] / n[k];
                            n[v] = 0;
                            o[j] = "";
                            ++j;
                        }
                    } while (o[++j].equals("*") || o[j].equals("/"));
                    m[j - 1] = n[j - 1];
                }
            }
            for (int i = 0; i < n.length; i++) {
                if (o[i].equals("-")) {
                    int k;
                    int j;
                    for (k = i; k < n.length; k++) {
                        if (n[k] == 0) continue;
                        else break;
                    }
                    for (j = i; j > 0; j--) {
                        if (n[j] == 0) continue;
                        else break;
                    }
                    m[j] = n[j];
                    m[k] = -n[k];
                    n[k] *= -1;
                }
            }
            for (int i = 0; i < n.length; i++) {
                if (o[i].equals("+")) {
                    int k;
                    int j;
                    for (k = i; k < n.length; k++) {
                        if (n[k] == 0) continue;
                        else break;
                    }
                    for (j = i; j > 0; j--) {
                        if (n[j] == 0) continue;
                        else break;
                    }
                    m[j] = n[j];
                    m[k] = n[k];
                } else ++f;
            }
            if (f == 64) m[0] = n[0];
        } catch (NumberFormatException | NullPointerException | StringIndexOutOfBoundsException |
                 ArrayIndexOutOfBoundsException ignored) {
        }
        for (double d : m) r += d;
        return r;
    }

    public N() {
        JButton jButtonMC = new JButton("MC");
        JButton jButtonMR = new JButton("MR");
        jButtonMR.addActionListener(e->resultjtf.setText(String.valueOf(MS)));
        JButton jButtonMS = new JButton("MS");
        JButton jButtonMPLUS = new JButton("M+");
        jButtonMPLUS.addActionListener(e->MS+=cal(all));
        JButton jButtonMMINUS = new JButton("M-");
        jButtonMMINUS.addActionListener(e->MS-=cal(all));
        JButton jButtonMSTATE = new JButton("M\\/");
        jButtonMC.addActionListener(e->{
            MS=0;MM=0;MP=0;
            jButtonMR.setForeground(Color.WHITE);
            jButtonMC.setForeground(Color.WHITE);
            jButtonMPLUS.setForeground(Color.WHITE);
            jButtonMMINUS.setForeground(Color.WHITE);
            jButtonMSTATE.setForeground(Color.WHITE);
        });
        jButtonMS.addActionListener(e->{
            MS=cal(all);
            jButtonMSTATE.setForeground(Color.RED);
            jButtonMR.setForeground(Color.BLACK);
            jButtonMC.setForeground(Color.BLACK);
            jButtonMPLUS.setForeground(Color.BLACK);
            jButtonMMINUS.setForeground(Color.BLACK);
        });
        SwingUtilities.invokeLater(() -> {
            setSize(400, 400);
            setTitle("翟金培-仿windows标准计算器");
            setResizable(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
            setContentPane(jPanel1);
            jPanel1.setLayout(new BorderLayout());
            jPanel2.setPreferredSize(new Dimension(0, 100));
            getContentPane().add(jPanel2, BorderLayout.NORTH);
            jPanel2.setLayout(new GridLayout(3, 1));
            jTextField.setFont(new Font("", Font.BOLD, 24));
            resultjtf.setFont(new Font("", Font.BOLD, 24));
            jTextField.setEditable(false);
            resultjtf.setEditable(false);
            JMenu jMenu = new JMenu("标准");
            JMenu jMenu1 = new JMenu("关于");
            JMenuItem jMenuItem = new JMenuItem("说明");
            JMenuItem jMenuItem1 = new JMenuItem("作者");
            JMenuItem jMenuItem2 = new JMenuItem("退出");
            jMenu1.add(jMenuItem);
            jMenu1.add(jMenuItem1);
            jMenu1.add(jMenuItem2);
            jMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "请尽量输入正确的表达式!\n数字总量建议不要超过30!\n精度问题自行判断\n一般取两位小数"));
            jMenuItem1.addActionListener(e -> JOptionPane.showMessageDialog(this, "软件2211 翟金培 2205221139"));
            jMenuItem2.addActionListener(e -> {
                JOptionPane.showMessageDialog(this,"感谢使用");
                System.exit(0);
            });
            jMenuBar.add(jMenu);
            jMenuBar.add(jMenu1);
            jPanel2.add(jMenuBar);
            jPanel2.add(jTextField);
            jPanel2.add(resultjtf);
            jPanel2.setVisible(true);
            getContentPane().add(jPanel4, BorderLayout.CENTER);
            jPanel4.setLayout(new GridLayout(1, 6, 0, 0));
            jPanel4.add(jButtonMC);
            jPanel4.add(jButtonMR);
            jPanel4.add(jButtonMS);
            jPanel4.add(jButtonMPLUS);
            jPanel4.add(jButtonMMINUS);
            jPanel4.add(jButtonMSTATE);
            jButtonMC.setForeground(Color.WHITE);
            jButtonMR.setForeground(Color.WHITE);
            jButtonMPLUS.setForeground(Color.WHITE);
            jButtonMMINUS.setForeground(Color.WHITE);
            jButtonMSTATE.setForeground(Color.WHITE);
            jPanel3.setPreferredSize(new Dimension(0, 240));
            getContentPane().add(jPanel3, BorderLayout.SOUTH);
            jPanel3.setLayout(new GridLayout(6, 4, 0, 0));
            jPanel3.setVisible(true);
            for (JButton jButton : jButtons) jPanel3.add(jButton);
        });
    }
}