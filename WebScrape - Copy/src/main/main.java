package main;

import com.jaeheonshim.tictactoeai.Board;
import com.jaeheonshim.tictactoeai.Main;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.jaeheonshim.tictactoeai.AI.getBestMove;

//https://devqa.io/selenium-css-selectors/
//https://www.toolsqa.com/selenium-webdriver/write-effective-xpaths/
//https://stackoverflow.com/questions/57943607/how-to-track-dynamically-updating-code-using-selenium-in-python
//https://stackoverflow.com/questions/19906401/how-can-i-make-a-method-repeat-itself-java
//java -jar C:/Users/#USERNAMEHERE/IdeaProjects/WebScrape/out/artifacts/WebScrape_jar/Webscrape.jar

public class main {
    public static void main(String[] args) throws InterruptedException {
        String projectPath = System.getProperty("user.home");
        String projectPathToTheDriver = "\\IdeaProjects\\WebScrape\\Resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", projectPath + projectPathToTheDriver);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://playtictactoe.org/");
        Thread.sleep(4000);
        Random rand = new Random();
        Integer randomNum = rand.nextInt((2 - 1) + 1) + 1;
        if(randomNum.equals(1)) {
            Board board = new Board();
            board.printBoard();
            Integer[] move1 = getBestMove(board);
            Integer First = null;
            Integer Second = null;
            board.place(getBestMove(board), Board.CellState.X);
            board.printBoard();
            //System.out.print(move1[0] + " " + move1[1]);
            //board.place(move1, Board.CellState.O);
            //board.printBoard();
            String[][] squares = {{"square top left", "square top", "square top right"}, {"square left", "square", "square right"}, {"square bottom left", "square bottom", "square bottom right"}};
            String sitemove = squares[move1[0]][move1[1]];
            System.out.print(sitemove);
            driver.findElement(By.xpath("//div[@class='" + sitemove + "'][1]")).click();
            Thread.sleep(3000);
            while (driver.findElements(By.xpath("//div[@class='o'][1]/parent::div")).isEmpty()) {
                Thread.sleep(600);
            }
            WebElement e = driver.findElement(By.xpath("//div[@class='o'][1]/parent::div"));
            String B = e.getAttribute("class");
            System.out.print(B);
            List<WebElement> as = driver.findElements(By.xpath("//div[@class='o'][1]/parent::div"));
            Integer i = as.size();
            System.out.print(as.size());
            Iterator<WebElement> itr = as.iterator();
            String SSGIRLS = null;
            String SSGIRLS1 = null;
            String SSGIRLS2 = null;
            String SSGIRLS3 = null;
            String SSGIRLS4 = null;
            String SSGIRLS5 = null;
            Integer size1 = 0;
            while (itr.hasNext()) {
                String name = itr.next().getAttribute("class");
                System.out.println(name);
                if (size1.equals(0)) {
                    Thread.sleep(600);
                    System.out.println("hi");
                } else {
                    String name1 = itr.next().getAttribute("class");
                    System.out.println(name1);
                    size1 = size1 + 1;
                    break;
                }
            }

            for (int xxx = 0; xxx < squares.length; ++xxx) {
                for (int yyy = 0; yyy < squares[xxx].length; ++yyy) {
                    if (squares[xxx][yyy].equals(B)) {
                        First = xxx;
                        Second = yyy;
                    }
                }
            }
            Integer[] progmove = {First, Second};
            board.place(progmove, Board.CellState.O);
            board.printBoard();
            move1 = getBestMove(board);
            board.place(getBestMove(board), Board.CellState.X);
            board.printBoard();
            sitemove = squares[move1[0]][move1[1]];
            System.out.print(sitemove);
            driver.findElement(By.xpath("//div[@class='" + sitemove + "'][1]")).click();
            while (driver.findElements(By.xpath("//div[@class='o'][1]/parent::div")).size() == i) {
                Thread.sleep(600);
            }
            i++;
            List<WebElement> as1 = driver.findElements(By.xpath("//div[@class='o'][1]/parent::div"));
            Iterator<WebElement> itr1 = as1.iterator();
            while (itr1.hasNext()) {
                String name = itr1.next().getAttribute("class");
                System.out.println(name);
                if (!Objects.equals(B, name)) {
                    SSGIRLS = name;
                }
            }
            for (int xxx = 0; xxx < squares.length; ++xxx) {
                for (int yyy = 0; yyy < squares[xxx].length; ++yyy) {
                    if (squares[xxx][yyy].equals(SSGIRLS)) {
                        First = xxx;
                        Second = yyy;
                    }
                }
            }
            Integer[] progmove1 = {First, Second};
            board.place(progmove1, Board.CellState.O);
            board.printBoard();
            Integer[] move2 = getBestMove(board);
            board.place(getBestMove(board), Board.CellState.X);
            board.printBoard();
            String sitemove1 = squares[move2[0]][move2[1]];
            System.out.print(sitemove1);
            driver.findElement(By.xpath("//div[@class='" + sitemove1 + "'][1]")).click();
            while (driver.findElements(By.xpath("//div[@class='o'][1]/parent::div")).size() == i) {
                Thread.sleep(600);
            }
            i++;
            List<WebElement> as3 = driver.findElements(By.xpath("//div[@class='o'][1]/parent::div"));
            Iterator<WebElement> itr3 = as3.iterator();
            while (itr3.hasNext()) {
                String name = itr3.next().getAttribute("class");
                System.out.println(name);
                if (!Objects.equals(B, name)) {
                    if (!Objects.equals(SSGIRLS, name)) {
                        SSGIRLS1 = name;
                    }
                }
            }
            for (int xxx = 0; xxx < squares.length; ++xxx) {
                for (int yyy = 0; yyy < squares[xxx].length; ++yyy) {
                    if (squares[xxx][yyy].equals(SSGIRLS1)) {
                        First = xxx;
                        Second = yyy;
                    }
                }
            }
            Integer[] progmove2 = new Integer[]{First, Second};
            board.place(progmove2, Board.CellState.O);
            board.printBoard();
            Integer[] move3 = getBestMove(board);
            board.place(getBestMove(board), Board.CellState.X);
            board.printBoard();
            String sitemove2 = squares[move3[0]][move3[1]];
            System.out.print(sitemove2);
            driver.findElement(By.xpath("//div[@class='" + sitemove2 + "'][1]")).click();
            while (driver.findElements(By.xpath("//div[@class='o'][1]/parent::div")).size() == i) {
                Thread.sleep(600);
            }
            i++;
            List<WebElement> as4 = driver.findElements(By.xpath("//div[@class='o'][1]/parent::div"));
            Iterator<WebElement> itr4 = as4.iterator();
            while (itr4.hasNext()) {
                String name = itr4.next().getAttribute("class");
                System.out.println(name);
                if (!Objects.equals(B, name)) {
                    if (!Objects.equals(SSGIRLS, name)) {
                        if (!Objects.equals(SSGIRLS1, name)) {
                            SSGIRLS2 = name;
                        }
                    }
                }
            }
            for (int xxx = 0; xxx < squares.length; ++xxx) {
                for (int yyy = 0; yyy < squares[xxx].length; ++yyy) {
                    if (squares[xxx][yyy].equals(SSGIRLS2)) {
                        First = xxx;
                        Second = yyy;
                    }
                }
            }
            Integer[] progmove3 = new Integer[]{First, Second};
            board.place(progmove3, Board.CellState.O);
            board.printBoard();
            Integer[] move4 = getBestMove(board);
            board.place(getBestMove(board), Board.CellState.X);
            board.printBoard();
            String sitemove3 = squares[move4[0]][move4[1]];
            System.out.print(sitemove3);
            driver.findElement(By.xpath("//div[@class='" + sitemove3 + "'][1]")).click();
            while (driver.findElements(By.xpath("//div[@class='o'][1]/parent::div")).size() == i) {
                Thread.sleep(600);
            }
            i++;
            List<WebElement> as5 = driver.findElements(By.xpath("//div[@class='o'][1]/parent::div"));
            Iterator<WebElement> itr5 = as5.iterator();
            while (itr5.hasNext()) {
                String name = itr5.next().getAttribute("class");
                System.out.println(name);
                if (!Objects.equals(B, name)) {
                    if (!Objects.equals(SSGIRLS, name)) {
                        if (!Objects.equals(SSGIRLS1, name)) {
                            if (!Objects.equals(SSGIRLS2, name)) {
                                SSGIRLS3 = name;
                            }
                        }
                    }
                }
            }
            for (int xxx = 0; xxx < squares.length; ++xxx) {
                for (int yyy = 0; yyy < squares[xxx].length; ++yyy) {
                    if (squares[xxx][yyy].equals(SSGIRLS3)) {
                        First = xxx;
                        Second = yyy;
                    }
                }
            }
            Integer[] progmove4 = {First, Second};
            board.place(progmove4, Board.CellState.O);
            board.printBoard();
            Integer[] move5 = getBestMove(board);
            board.place(getBestMove(board), Board.CellState.X);
            board.printBoard();
            String sitemove4 = squares[move5[0]][move5[1]];
            System.out.print(sitemove4);
            driver.findElement(By.xpath("//div[@class='" + sitemove4 + "'][1]")).click();
            while (driver.findElements(By.xpath("//div[@class='o'][1]/parent::div")).size() == i) {
                Thread.sleep(600);
            }
            i++;
            List<WebElement> as6 = driver.findElements(By.xpath("//div[@class='o'][1]/parent::div"));
            Iterator<WebElement> itr6 = as6.iterator();
            while (itr6.hasNext()) {
                String name = itr6.next().getAttribute("class");
                System.out.println(name);
                if (!Objects.equals(B, name)) {
                    if (!Objects.equals(SSGIRLS, name)) {
                        if (!Objects.equals(SSGIRLS1, name)) {
                            if (!Objects.equals(SSGIRLS2, name)) {
                                if (!Objects.equals(SSGIRLS3, name)) {
                                    SSGIRLS4 = name;
                                }
                            }
                        }
                    }
                }
            }
            for (int xxx = 0; xxx < squares.length; ++xxx) {
                for (int yyy = 0; yyy < squares[xxx].length; ++yyy) {
                    if (squares[xxx][yyy].equals(SSGIRLS4)) {
                        First = xxx;
                        Second = yyy;
                    }
                }
            }
            Integer[] progmove6 = new Integer[]{First, Second};
            board.place(progmove6, Board.CellState.O);
            board.printBoard();
            Integer[] move7 = getBestMove(board);
            board.place(getBestMove(board), Board.CellState.X);
            board.printBoard();
            String sitemove6 = squares[move7[0]][move7[1]];
            System.out.print(sitemove6);
            driver.findElement(By.xpath("//div[@class='" + sitemove6 + "'][1]")).click();
        }
        else{
            Board board = new Board();
            board.printBoard();
            String[][] squares = {{"square top left", "square top", "square top right"}, {"square left", "square", "square right"}, {"square bottom left", "square bottom", "square bottom right"}};
            while (driver.findElements(By.xpath("//div[@class='o'][1]/parent::div")).isEmpty()) {
                Thread.sleep(600);
            }
            WebElement e = driver.findElement(By.xpath("//div[@class='o'][1]/parent::div"));
            String B = e.getAttribute("class");
            System.out.print(B);
            List<WebElement> as = driver.findElements(By.xpath("//div[@class='o'][1]/parent::div"));
            Integer i = as.size();
            System.out.print(as.size());
            Iterator<WebElement> itr = as.iterator();
            Integer First = null;
            Integer Second = null;
            String SSGIRLS = null;
            String SSGIRLS1 = null;
            String SSGIRLS2 = null;
            String SSGIRLS3 = null;
            String SSGIRLS4 = null;
            String SSGIRLS5 = null;
            Integer size1 = 0;
            while (itr.hasNext()) {
                String name = itr.next().getAttribute("class");
                System.out.println(name);
                if (size1.equals(0)) {
                    Thread.sleep(600);
                    System.out.println("hi");
                } else {
                    String name1 = itr.next().getAttribute("class");
                    System.out.println(name1);
                    size1 = size1 + 1;
                    break;
                }
            }
            for (int xxx = 0; xxx < squares.length; ++xxx) {
                for (int yyy = 0; yyy < squares[xxx].length; ++yyy) {
                    if (squares[xxx][yyy].equals(B)) {
                        First = xxx;
                        Second = yyy;
                    }
                }
            }
            Integer[] sitemove = {First, Second};
            board.place(sitemove, Board.CellState.X);
            board.printBoard();
            Integer[] move1 = getBestMove(board);
            board.place(getBestMove(board), Board.CellState.O);
            board.printBoard();
            String progmove = squares[move1[0]][move1[1]];
            System.out.print(progmove);
            driver.findElement(By.xpath("//div[@class='" + progmove + "'][1]")).click();
            while (driver.findElements(By.xpath("//div[@class='o'][1]/parent::div")).size() == i) {
                Thread.sleep(600);
            }
            i++;
            List<WebElement> as1 = driver.findElements(By.xpath("//div[@class='o'][1]/parent::div"));
            Iterator<WebElement> itr1 = as1.iterator();
            while (itr1.hasNext()) {
                String name = itr1.next().getAttribute("class");
                System.out.println(name);
                if (!Objects.equals(B, name)) {
                    SSGIRLS = name;
                }
            }
            for (int xxx = 0; xxx < squares.length; ++xxx) {
                for (int yyy = 0; yyy < squares[xxx].length; ++yyy) {
                    if (squares[xxx][yyy].equals(SSGIRLS)) {
                        First = xxx;
                        Second = yyy;
                    }
                }
            }
            Integer[] sitemove1 = {First, Second};
            board.place(sitemove1, Board.CellState.X);
            board.printBoard();
            Integer[] move2 = getBestMove(board);
            board.place(getBestMove(board), Board.CellState.O);
            board.printBoard();
            String progmove1 = squares[move2[0]][move2[1]];
            System.out.print(progmove1);
            driver.findElement(By.xpath("//div[@class='" + progmove1 + "'][1]")).click();
            while (driver.findElements(By.xpath("//div[@class='o'][1]/parent::div")).size() == i) {
                Thread.sleep(600);
            }
            i++;
            List<WebElement> as3 = driver.findElements(By.xpath("//div[@class='o'][1]/parent::div"));
            Iterator<WebElement> itr3 = as3.iterator();
            while (itr3.hasNext()) {
                String name = itr3.next().getAttribute("class");
                System.out.println(name);
                if (!Objects.equals(SSGIRLS, name)) {
                    if (!Objects.equals(B, name)) {
                        SSGIRLS1 = name;
                    }
                }
            }
            for (int xxx = 0; xxx < squares.length; ++xxx) {
                for (int yyy = 0; yyy < squares[xxx].length; ++yyy) {
                    if (squares[xxx][yyy].equals(SSGIRLS1)) {
                        First = xxx;
                        Second = yyy;
                    }
                }
            }
            Integer[] sitemove2 = {First, Second};
            board.place(sitemove2, Board.CellState.X);
            board.printBoard();
            Integer[] move3 = getBestMove(board);
            board.place(getBestMove(board), Board.CellState.O);
            board.printBoard();
            String progmove2 = squares[move3[0]][move3[1]];
            System.out.print(progmove2);
            driver.findElement(By.xpath("//div[@class='" + progmove2 + "'][1]")).click();
            while (driver.findElements(By.xpath("//div[@class='o'][1]/parent::div")).size() == i) {
                Thread.sleep(600);
            }
            i++;
            List<WebElement> as4 = driver.findElements(By.xpath("//div[@class='o'][1]/parent::div"));
            Iterator<WebElement> itr4 = as4.iterator();
            while (itr4.hasNext()) {
                String name = itr4.next().getAttribute("class");
                System.out.println(name);
                if (!Objects.equals(SSGIRLS, name)) {
                    if (!Objects.equals(SSGIRLS1, name)) {
                        if (!Objects.equals(B, name)) {
                            SSGIRLS2 = name;
                        }
                    }
                }
            }
            for (int xxx = 0; xxx < squares.length; ++xxx) {
                for (int yyy = 0; yyy < squares[xxx].length; ++yyy) {
                    if (squares[xxx][yyy].equals(SSGIRLS2)) {
                        First = xxx;
                        Second = yyy;
                    }
                }
            }
            Integer[] sitemove3 = {First, Second};
            board.place(sitemove3, Board.CellState.X);
            board.printBoard();
            Integer[] move4 = getBestMove(board);
            board.place(getBestMove(board), Board.CellState.O);
            board.printBoard();
            String progmove3 = squares[move4[0]][move4[1]];
            System.out.print(progmove3);
            driver.findElement(By.xpath("//div[@class='" + progmove3 + "'][1]")).click();
            while (driver.findElements(By.xpath("//div[@class='o'][1]/parent::div")).size() == i) {
                Thread.sleep(600);
            }
            i++;
            List<WebElement> as5 = driver.findElements(By.xpath("//div[@class='o'][1]/parent::div"));
            Iterator<WebElement> itr5 = as5.iterator();
            while (itr5.hasNext()) {
                String name = itr5.next().getAttribute("class");
                System.out.println(name);
                if (!Objects.equals(SSGIRLS, name)) {
                    if (!Objects.equals(SSGIRLS1, name)) {
                        if (!Objects.equals(SSGIRLS2, name)) {
                            if (!Objects.equals(B, name)) {
                                SSGIRLS3 = name;
                            }
                        }
                    }
                }
            }
            for (int xxx = 0; xxx < squares.length; ++xxx) {
                for (int yyy = 0; yyy < squares[xxx].length; ++yyy) {
                    if (squares[xxx][yyy].equals(SSGIRLS3)) {
                        First = xxx;
                        Second = yyy;
                    }
                }
            }
            Integer[] sitemove5 = {First, Second};
            board.place(sitemove5, Board.CellState.X);
            board.printBoard();
            Integer[] move5 = getBestMove(board);
            board.place(getBestMove(board), Board.CellState.O);
            board.printBoard();
            String progmove5 = squares[move5[0]][move5[1]];
            System.out.print(progmove5);
            driver.findElement(By.xpath("//div[@class='" + progmove5 + "'][1]")).click();
        }
    }
}
        //System.out.print(e.getAttribute("class"));
        //WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0]" +
                //".parentNode;", e);
        //String B = parent.getAttribute("class");
        //System.out.print(B);
