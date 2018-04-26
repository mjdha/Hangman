package com.company;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("awkward");
        words.add("bagpipes");
        words.add("banjo");
        words.add("bungler");
        words.add("croquet");
        words.add("crypt");
        words.add("dwarves");
        words.add("fervid");
        words.add("fishhook");
        words.add("redi");
        while (true) {
            int random = getRandomNumberInRange(0, words.size() - 1);
            String thisGame = words.get(random);
            logic(thisGame);
            Scanner input = new Scanner(System.in);
            String playAgain = "";
            while (!playAgain.equalsIgnoreCase("yes") && !playAgain.equalsIgnoreCase("no")) {
                System.out.println("Would you like to play again? \nplease Enter Yes or No: ");
                playAgain = input.nextLine();
            }
            if (playAgain.equalsIgnoreCase("no")) {
                System.out.println("Game Over. Thanks for playing. :)");
                break;
            }
        }
    }

    public static void logic(String thisGame) {
        Scanner input = new Scanner(System.in);
        ArrayList<Character> lbl = new ArrayList<>();
        int numOfCor = 0;
        for (int i = 0; i < thisGame.length(); i++) {
            lbl.add(thisGame.charAt(i));
        }
        System.out.println("Hey Welcome to Hangman you have " + lbl.size() + " Guesses so GoodLuck! :D");

        ArrayList<Character> ingame = new ArrayList<>(Arrays.asList('_', '_', '_', '_', '_', '_', '_', '_', '_'));
        ArrayList<Character> usrAry = new ArrayList<>();


        for (int guessnum = 0; guessnum < lbl.size(); guessnum++) {
            String user = input.nextLine();
            char guess = user.charAt(0);

            for (int x = 0; x < lbl.size(); x++) {
                if (user.equalsIgnoreCase(thisGame)) {
                    numOfCor = lbl.size();

                }
                if (!usrAry.contains(guess) && guess == lbl.get(x) && numOfCor != lbl.size() && ingame.get(x) == '_') {
                    ingame.set(x, lbl.get(x));
                    numOfCor += 1;
                    usrAry.add(guess);
                    break;
                }

            }
            if (numOfCor != lbl.size()) {
                System.out.println(ingame.subList(0, lbl.size()));
            }

            if (numOfCor == lbl.size()) {
                System.out.println("You Saved the man\n " + "┌─-┐\n" +
                        " │     Ó\n" +
                        " │    /│\\\n" +
                        " │    /-\\" +
                        " \n ┴" + "\nand you Guessed the word " + thisGame);
                break;
            }
            if (numOfCor != lbl.size() && guessnum == lbl.size() - 1) {
                System.out.println("You killed the man\n " + "┌─-┐\n" +
                        " │  Ó\n" +
                        " │ /│\\\n" +
                        " │ /-\\" +
                        " \n ┴" + "\nThe word was " + thisGame + "." + "\nBetter luck next time!");
                break;
            }
        }

    }


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
