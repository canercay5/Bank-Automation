package CanerBank;

import java.sql.*;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

interface db_müsteri{
	public void insert();
	public void delete();
	public String getMüs();
	public List<String> getAllMüs();
}
interface db_personel{
	public List<String> personelGiris();
	public String[][] getAllCustomers();
	public void insert_per(long tckno, String name, String surname, String birth, String address, 
	int salary, int password, String telefon);
	//Overload fonskiyonlarım burada...
	public String[] getPersonel();
	public String[] getPersonel(String yetki);
}
interface db_admin{
	public List<String> adminGiris();
	public List<String> getAnket();
	public void insertAnket(int puan, String feedback);
	public String[][] getAllReports();
	public void changeSalary(long tckno, int newSalary);
	
 
}

public class DataBase implements db_admin, db_müsteri,db_personel {
	
	public List<String> getAnket() {
        Connection connect = null;
        PreparedStatement st11 = null;
        ResultSet rs = null;

        List<String> anketList = new ArrayList<>();

        try {
            connect = getConnection();
            String sql = "SELECT puan, feedback FROM canerbank.anket";
            st11 = connect.prepareStatement(sql);
            rs = st11.executeQuery();

            while (rs.next()) {
                int puan = rs.getInt("puan");
                String feedback = rs.getString("feedback");

                String anketItem = String.format("Puan: %d, Feedback: %s", puan, feedback);
                anketList.add(anketItem);
            }
        } catch (SQLException e) {
            System.out.println("Anket Bilgisi Getirme Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st11 != null) {
                    st11.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return anketList;
    }
	
	public void insertAnket(int puan, String feedback) {
        Connection connect = null;
        PreparedStatement st10 = null;

        try {
            connect = getConnection();
            String sql = "INSERT INTO canerbank.anket (puan, feedback) VALUES (?, ?)";
            st10 = connect.prepareStatement(sql);
            st10.setInt(1, puan);
            st10.setString(2, feedback);
            st10.executeUpdate();

            System.out.println("Anket Başarıyla Eklendi.");
        } catch (SQLException e) {
            System.out.println("Anket Ekleme Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st10 != null) {
                    st10.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public List<String> adminGiris() {
	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    List<String> tcknoAndPasswordList = new ArrayList<>();

	    try {
	        connect = getConnection();
	        String sql = "SELECT tckno, password FROM canerbank.admin";
	        statement = connect.prepareStatement(sql);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            long adminTCKNO = resultSet.getLong("tckno");
	            int password = resultSet.getInt("password");

	            String tcknoAndPassword = adminTCKNO + " " + password;
	            tcknoAndPasswordList.add(tcknoAndPassword);
	        }
	    } catch (SQLException e) {
	        System.out.println("Admin TCKNO ve Şifre Bilgilerini Alma Başarısız.");
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return tcknoAndPasswordList;
	}

	
	public List<String> personelGiris() {
	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    List<String> tcAndPasswordList = new ArrayList<>();

	    try {
	        connect = getConnection();
	        String sql = "SELECT tckno, password FROM canerbank.personel";
	        statement = connect.prepareStatement(sql);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            long personelTCKNO = resultSet.getLong("tckno");
	            int password = resultSet.getInt("password");

	            String tcAndPassword = personelTCKNO + " " + password;
	            tcAndPasswordList.add(tcAndPassword);
	        }
	    } catch (SQLException e) {
	        System.out.println("Personel TC ve Şifre Bilgilerini Alma Başarısız.");
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return tcAndPasswordList;
	}


	
	public String[][] getAllReports() {
	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    List<String[]> reportList = new ArrayList<>();

	    try {
	        connect = getConnection();
	        String sql = "SELECT * FROM canerbank.reports";
	        statement = connect.prepareStatement(sql);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            String[] reportInfo = new String[2];
	            reportInfo[0] = String.valueOf(resultSet.getInt("reports_id"));
	            reportInfo[1] = resultSet.getString("rapor");

	            reportList.add(reportInfo);
	        }
	    } catch (SQLException e) {
	        System.out.println("Rapor Bilgilerini Alma Başarısız.");
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return reportList.toArray(new String[0][]);
	}

	
	public void changeDurum(long tckno, boolean yeniDurum) {
	    Connection connect = null;
	    PreparedStatement statement = null;

	    try {
	        connect = getConnection();
	        String sql = "UPDATE canerbank.credit SET durum=? WHERE tckno=?";
	        statement = connect.prepareStatement(sql);
	        statement.setBoolean(1, yeniDurum);
	        statement.setLong(2, tckno);
	        statement.executeUpdate();

	        System.out.println("Kredi Durumu Başarıyla Güncellendi.");
	    } catch (SQLException e) {
	        System.out.println("Kredi Durumu Güncelleme Başarısız.");
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void insertCredit(long tckno, int kredi, boolean durum) {
        Connection connect = null;
        PreparedStatement statement = null;

        try {
            connect = getConnection();
            String sql = "INSERT INTO canerbank.credit (tckno, kredi, durum) VALUES (?, ?, ?)";
            statement = connect.prepareStatement(sql);
            statement.setLong(1, tckno);
            statement.setInt(2, kredi);
            statement.setBoolean(3, durum);
            statement.executeUpdate();

            System.out.println("Kredi Bilgisi Başarıyla Eklendi.");
        } catch (SQLException e) {
            System.out.println("Kredi Bilgisi Ekleme Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


	public String[][] getAllCreditInfo() {
	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    List<String[]> creditInfoList = new ArrayList<>();

	    try {
	        connect = getConnection();
	        String sql = "SELECT * FROM canerbank.credit";
	        statement = connect.prepareStatement(sql);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            String[] creditInfo = new String[3];
	            creditInfo[0] = String.valueOf(resultSet.getLong("tckno"));
	            creditInfo[1] = String.valueOf(resultSet.getInt("kredi"));
	            creditInfo[2] = String.valueOf(resultSet.getBoolean("durum"));

	            creditInfoList.add(creditInfo);
	        }
	    } catch (SQLException e) {
	        System.out.println("Kredi Bilgilerini Alma Başarısız.");
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return creditInfoList.toArray(new String[0][]);
	}
	
	public void changeSalary(long tckno, int newSalary) {
	    Connection connect = null;
	    PreparedStatement statement = null;

	    try {
	        connect = getConnection();
	        String sql = "UPDATE canerbank.personel SET salary=? WHERE tckno=?";
	        statement = connect.prepareStatement(sql);
	        statement.setInt(1, newSalary);
	        statement.setLong(2, tckno);
	        statement.executeUpdate();

	        System.out.println("Maaş Başarıyla Güncellendi.");
	    } catch (SQLException e) {
	        System.out.println("Maaş Güncelleme Başarısız.");
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public String[][] getAllCustomers() {
	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    List<String[]> customersInfoList = new ArrayList<>();

	    try {
	        connect = getConnection();
	        String sql = "SELECT * FROM canerbank.müsteri";
	        statement = connect.prepareStatement(sql);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            String[] customerInfo = new String[8];
	            customerInfo[0] = String.valueOf(resultSet.getLong("tckno"));
	            customerInfo[1] = resultSet.getString("name");
	            customerInfo[2] = resultSet.getString("surname");
	            customerInfo[3] = resultSet.getString("birth");
	            customerInfo[4] = resultSet.getString("address");
	            customerInfo[5] = String.valueOf(resultSet.getInt("balance"));
	            customerInfo[6] = String.valueOf(resultSet.getInt("password"));
	            customerInfo[7] = resultSet.getString("telefon");

	            customersInfoList.add(customerInfo);
	        }
	    } catch (SQLException e) {
	        System.out.println("Müşteri Bilgilerini Alma Başarısız.");
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return customersInfoList.toArray(new String[0][]);
	}

	
	public String[][] getAllEmployees() {
	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    List<String[]> employeesInfoList = new ArrayList<>();

	    try {
	        connect = getConnection();
	        String sql = "SELECT * FROM canerbank.personel";
	        statement = connect.prepareStatement(sql);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            String[] employeeInfo = new String[8];
	            employeeInfo[0] = String.valueOf(resultSet.getLong("tckno"));
	            employeeInfo[1] = resultSet.getString("name");
	            employeeInfo[2] = resultSet.getString("surname");
	            employeeInfo[3] = resultSet.getString("birth");
	            employeeInfo[4] = resultSet.getString("address");
	            employeeInfo[5] = String.valueOf(resultSet.getInt("salary"));
	            employeeInfo[6] = String.valueOf(resultSet.getInt("password"));
	            employeeInfo[7] = resultSet.getString("telefon");

	            employeesInfoList.add(employeeInfo);
	        }
	    } catch (SQLException e) {
	        System.out.println("Personel Bilgilerini Alma Başarısız.");
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return employeesInfoList.toArray(new String[0][]);
	}

	
	public String[] getEmployees() {
	    Connection connect = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    List<String> employeeInfoList = new ArrayList<>();

	    try {
	        connect = getConnection();
	        String sql = "SELECT * FROM canerbank.personel";
	        statement = connect.prepareStatement(sql);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            String employeeInfo = String.format(
	                    "%d, %s, %s, %s, %s, %d, %d, %s",
	                    resultSet.getLong("tckno"),
	                    resultSet.getString("name"),
	                    resultSet.getString("surname"),
	                    resultSet.getString("birth"),
	                    resultSet.getString("address"),
	                    resultSet.getInt("salary"),
	                    resultSet.getInt("password"),
	                    resultSet.getString("telefon")
	            );

	            employeeInfoList.add(employeeInfo);
	        }
	    } catch (SQLException e) {
	        System.out.println("Personel Bilgilerini Alma Başarısız.");
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return employeeInfoList.toArray(new String[0]);
	}

    public void insert(long tckno, int password, String name, String surname,
                       String birth, String address, int balance, String telefon) {
        Connection connect = null;
        PreparedStatement st1 = null;

        try {
            connect = getConnection();
            String sql = "INSERT INTO canerbank.müsteri " +
                         "(tckno, name, surname, birth, address, balance, password, telefon) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            st1 = connect.prepareStatement(sql);
            st1.setLong(1, tckno);
            st1.setString(2, name);
            st1.setString(3, surname);
            st1.setString(5, birth);
            st1.setString(4, address);
            st1.setInt(6, balance);
            st1.setInt(7, password);
            st1.setString(8, telefon);
            st1.executeUpdate();

            System.out.println("Müşteri Başarıyla Kaydedildi.");
        } catch (SQLException e) {
            System.out.println("Müşteri Kaydet Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st1 != null) {
                    st1.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void insert_per(long tckno, String name, String surname, String birth, String address, int salary, int password, String telefon) {
        Connection connect = null;
        PreparedStatement st8 = null;

        try {
            connect = getConnection();
            String sql = "INSERT INTO canerbank.personel " +
                         "(tckno, name, surname, birth, address, salary, password,telefon) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            st8 = connect.prepareStatement(sql);
            st8.setLong(1, tckno);
            st8.setString(2, name);
            st8.setString(3, surname);
            st8.setString(4, birth);
            st8.setString(5, address);
            st8.setInt(6, salary);
            st8.setInt(7, password);
            st8.setString(8, telefon);
            st8.executeUpdate();

            System.out.println("Personel Başarıyla Kaydedildi.");
        } catch (SQLException e) {
            System.out.println("Personel Kaydetme Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st8 != null) {
                    st8.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void delete(long tckno) {
        Connection connect = null;
        PreparedStatement st2 = null;

        try {
            connect = getConnection();
            String sql = "DELETE FROM canerbank.müsteri WHERE tckno=?";
            st2 = connect.prepareStatement(sql);
            st2.setLong(1, tckno);
            int affectedRows = st2.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Müşteri Başarıyla Silindi.");
            } else {
                System.out.println("Belirtilen Kimlik Numarasına Sahip Müşteri Bulunamadı.");
            }
        } catch (SQLException e) {
            System.out.println("Müşteri Silme Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st2 != null) {
                    st2.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void delete_per(long tckno) {
        Connection connect = null;
        PreparedStatement statement = null;

        try {
            connect = getConnection();
            String sql = "DELETE FROM canerbank.personel WHERE tckno=?";
            statement = connect.prepareStatement(sql);
            statement.setLong(1, tckno);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Personel Başarıyla Silindi.");
            } else {
                System.out.println("Belirtilen TCKNO'ya Sahip Personel Bulunamadı.");
            }
        } catch (SQLException e) {
            System.out.println("Personel Silme Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
    public String getMüs(Double tckno) {
        Connection connect = null;
        PreparedStatement st3 = null;
        ResultSet resultSet = null;

        try {
            connect = getConnection();
            String sql = "SELECT * FROM canerbank.müsteri WHERE tckno=?";
            st3 = connect.prepareStatement(sql);
            st3.setDouble(1, tckno);
            resultSet = st3.executeQuery();

            if (resultSet.next()) {
                
                long müsteriTckno = resultSet.getLong("tckno");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                /*String birth = resultSet.getString("birth");
                String address = resultSet.getString("address");
                int password = resultSet.getInt("password");*/
                
                int balance = resultSet.getInt("balance");
                
                String müsString = "TCKNO: " + müsteriTckno +
                        ", Name: " + name +
                        ", Surname: " + surname +
                        ", Balance: " + balance;

                return müsString;
            } else {
                return "Belirtilen Kimlik Numarasına Sahip Müşteri Bulunamadı.";
            }
        } catch (SQLException e) {
            System.out.println("Müşteri Bilgilerini Alma Başarısız.");
            e.printStackTrace();
            return "Bilgi Alınamadı";
        } catch (Exception e) {
            e.printStackTrace();
            return "Bilgi Alınamadı";
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (st3 != null) {
                    st3.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public List<String> getAllMüs() {
        Connection connect = null;
        PreparedStatement st4 = null;
        ResultSet resultSet = null;

        List<String> müsList = new ArrayList<>();

        try {
            connect = getConnection();
            String sql = "SELECT * FROM canerbank.müsteri";
            st4 = connect.prepareStatement(sql);
            resultSet = st4.executeQuery();

            while (resultSet.next()) {
                long müsteriTckno = resultSet.getLong("tckno");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int balance = resultSet.getInt("balance");
                /*String birth = resultSet.getString("birth");
                String address = resultSet.getString("address");
                int password = resultSet.getInt("password");*/

                String müsString = müsteriTckno +
                        " " + name +
                        " " + surname +
                        " " + balance ;
                        

                müsList.add(müsString);
            }
        } catch (SQLException e) {
            System.out.println("Müşteri Bilgilerini Alma Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (st4 != null) {
                    st4.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return müsList;
    }

    public void changeBalance(long tckno, int newBalance) {
        Connection connect = null;
        PreparedStatement st5 = null;

        try {
            connect = getConnection();
            String sql = "UPDATE canerbank.müsteri SET balance=? WHERE tckno=?";
            st5 = connect.prepareStatement(sql);
            st5.setInt(1, newBalance);
            st5.setLong(2, tckno);
            st5.executeUpdate();

            System.out.println("Bakiye Başarıyla Güncellendi.");
        } catch (SQLException e) {
            System.out.println("Bakiye Güncelleme Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st5 != null) {
                    st5.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public List<String> getAllTCAndPasswords() {
        Connection connect = null;
        PreparedStatement st7 = null;
        ResultSet resultSet = null;

        List<String> tcAndPasswordList = new ArrayList<>();

        try {
            connect = getConnection();
            String sql = "SELECT tckno, password FROM canerbank.müsteri";
            st7 = connect.prepareStatement(sql);
            resultSet = st7.executeQuery();

            while (resultSet.next()) {
                long müsteriTCKNO = resultSet.getLong("tckno");
                int password = resultSet.getInt("password");

                String tcAndPassword = müsteriTCKNO + " " + password;
                tcAndPasswordList.add(tcAndPassword);
            }
        } catch (SQLException e) {
            System.out.println("TCKNO ve Şifre Bilgilerini Alma Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (st7 != null) {
                    st7.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tcAndPasswordList;
       }
    
    public int getBalance(long tckno) {
        Connection connect = null;
        PreparedStatement st6 = null;
        ResultSet resultSet = null;

        try {
            connect = getConnection();
            String sql = "SELECT balance FROM canerbank.müsteri WHERE tckno=?";
            st6 = connect.prepareStatement(sql);
            st6.setLong(1, tckno);
            resultSet = st6.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("balance");
            } else {
                System.out.println("Belirtilen Kimlik Numarasına Sahip Müşteri Bulunamadı.");
                return -1; 
            }
        } catch (SQLException e) {
            System.out.println("Bakiye Bilgisini Alma Başarısız.");
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (st6 != null) {
                    st6.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void getCredit(long tckno, int kredi) {
        Connection connect = null;
        PreparedStatement st9 = null;

        try {
            connect = getConnection();
            String sql = "UPDATE canerbank.credit SET kredi=? WHERE tckno=?";
            st9 = connect.prepareStatement(sql);
            st9.setInt(1, kredi);
            st9.setLong(2, tckno);
            st9.executeUpdate();

            System.out.println("Kredi Başarıyla Güncellendi.");
        } catch (SQLException e) {
            System.out.println("Kredi Güncelleme Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st9 != null) {
                    st9.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void updatePassword(long tckno, int newPassword) {
        Connection connect = null;
        PreparedStatement st10 = null;

        try {
            connect = getConnection();
            String sql = "UPDATE canerbank.müsteri SET password=? WHERE tckno=?";
            st10 = connect.prepareStatement(sql);
            st10.setInt(1, newPassword);
            st10.setLong(2, tckno);
            st10.executeUpdate();

            System.out.println("Şifre Başarıyla Güncellendi.");
        } catch (SQLException e) {
            System.out.println("Şifre Güncelleme Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st10 != null) {
                    st10.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void setRapor(int reportId, String rapor) {
        Connection connect = null;
        PreparedStatement st11 = null;

        try {
            connect = getConnection();
            String sql = "INSERT INTO canerbank.reports (reports_id, rapor) VALUES (?, ?)";
            st11 = connect.prepareStatement(sql);
            st11.setInt(1, reportId);
            st11.setString(2, rapor);
            st11.executeUpdate();

            System.out.println("Rapor Başarıyla Eklendi.");
        } catch (SQLException e) {
            System.out.println("Rapor Ekleme Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st11 != null) {
                    st11.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public HashMap<Integer, String> getRapor() {
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;

        HashMap<Integer, String> raporMap = new HashMap<>();

        try {
            connect = getConnection();
            statement = connect.createStatement();
            String sql = "SELECT * FROM canerbank.reports";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int reportId = resultSet.getInt("reports_id");
                String rapor = resultSet.getString("rapor");

                raporMap.put(reportId, rapor);
            }

        } catch (SQLException e) {
            System.out.println("Raporları Alma Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return raporMap;
    }


    
    public String[] getPersonel(String yetki) {
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<String> personelBilgileri = new ArrayList<>();

        try {
            connect = getConnection();
            String sql = "SELECT * FROM canerbank.personel";
            statement = connect.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long tckno = resultSet.getLong("tckno");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                
                /*String birth = resultSet.getString("birth");
                String address = resultSet.getString("address");*/
                int salary = resultSet.getInt("salary");
                int password = resultSet.getInt("password");
                String telfn = resultSet.getString("telefon");
                if(yetki == "yönetici") {
                	String personelString =tckno +
                            " " + name +
                            " " + surname +
                            " " + salary +
                            " " + password +
                            " " + telfn;
                		personelBilgileri.add(personelString);
                }
                else {
                	String personelString = name + " " + surname + " " + telfn;;
                	personelBilgileri.add(personelString);
                            
				}         
            }

        } catch (SQLException e) {
            System.out.println("Personel Bilgilerini Alma Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        String[] personelArray = new String[personelBilgileri.size()];
        personelArray = personelBilgileri.toArray(personelArray);

        return personelArray;
    }
    
    public String[] getPersonel() {
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<String> personelBilgileri = new ArrayList<>();

        try {
            connect = getConnection();
            String sql = "SELECT * FROM canerbank.personel";
            statement = connect.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String telfn = resultSet.getString("telefon");
            	String personelString = name + " " + surname + " " + telfn;;
            	personelBilgileri.add(personelString);
            }

        } catch (SQLException e) {
            System.out.println("Personel Bilgilerini Alma Başarısız.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        String[] personelArray = new String[personelBilgileri.size()];
        personelArray = personelBilgileri.toArray(personelArray);

        return personelArray;
    }
    
    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/canerbank";
            String username = "root";
            String password = "123456";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database bağlandı.");
            return conn;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMüs() {
		// TODO Auto-generated method stub
		return null;
	}
}
