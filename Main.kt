package machine

import kotlin.system.exitProcess
import java.util.Scanner

var water = 400
var milk = 540
var beans = 120
var cups = 9
var money = 550
val scanner = Scanner(System.`in`)

fun fill (){
    println()
    print("Write how many ml of water do you want to add: ")
    val addWater = scanner.nextInt()
    print("Write how many ml of milk do you want to add: ")
    val addMilk = scanner.nextInt()
    print("Write how many grams of coffee beans do you want to add: ")
    val addBeans = scanner.nextInt()
    print("Write how many disposable cups of coffee do you want to add: ")
    val addCups = scanner.nextInt()
    println()

    water += addWater
    milk += addMilk
    beans += addBeans
    cups += addCups
}

fun buy () {
    print("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    val coffeeOption = scanner.next()

    val espresso = mutableListOf(250, 0, 16, -4)
    val latte = mutableListOf(350, 75, 20, -7)
    val cappuccino = mutableListOf(200, 100, 12, -6)
    when (coffeeOption) {
        "1" -> if (water >= espresso[0] && milk >= espresso[1] && beans >= espresso[2]) {
            println("I have enough resources, making you a coffee!\n")
            water -= espresso[0]
            milk -= espresso[1]
            beans -= espresso[2]
            money -= espresso[3]
            cups--
        } else if (water < espresso[0] && milk >= espresso[1] && beans >= espresso[2]) {
            println("Sorry, not enough water!\n")
        } else if (water >= espresso[0] && milk < espresso[1] && beans >= espresso[2]) {
            println("Sorry, not enough milk!\n")
        } else if (water >= espresso[0] && milk >= espresso[1] && beans < espresso[2]) {
            println("Sorry, not enough coffee beans!\n")
        }
        "2" -> if (water >= latte[0] && milk >= latte[1] && beans >= latte[2]) {
            println("I have enough resources, making you a coffee!\n")
            water -= latte[0]
            milk -= latte[1]
            beans -= latte[2]
            money -= latte[3]
            cups--
        } else if (water < latte[0] && milk >= latte[1] && beans >= latte[2]) {
            println("Sorry, not enough water!\n")
        } else if (water >= latte[0] && milk < latte[1] && beans >= latte[2]) {
            println("Sorry, not enough milk!\n")
        } else if (water >= latte[0] && milk >= latte[1] && beans < latte[2]) {
            println("Sorry, not enough coffee beans!\n")
        }
        "3" -> if (water >= cappuccino[0] && milk >= cappuccino[1] && beans >= cappuccino[2]) {
            println("I have enough resources, making you a coffee!\n")
            water -= cappuccino[0]
            milk -= cappuccino[1]
            beans -= cappuccino[2]
            money -= cappuccino[3]
            cups--
        } else if (water < cappuccino[0] && milk >= cappuccino[1] && beans >= cappuccino[2]) {
            println("Sorry, not enough water!\n")
        } else if (water >= cappuccino[0] && milk < cappuccino[1] && beans >= cappuccino[2]) {
            println("Sorry, not enough milk!\n")
        } else if (water >= cappuccino[0] && milk >= cappuccino[1] && beans < cappuccino[2]) {
            println("Sorry, not enough coffee beans!\n")
        }
    }

}
fun take () {
    println("\nI gave you \$$money\n")
    money = 0

}

fun remaining () {
    if (money == 0) {
        println("\nThe coffee machine has:\n" +
                "$water of water\n" +
                "$milk of milk\n" +
                "$beans of coffee beans\n" +
                "$cups of disposable cups\n" +
                "$money of money\n")
    } else println("\nThe coffee machine has:\n" +
            "$water of water\n" +
            "$milk of milk\n" +
            "$beans of coffee beans\n" +
            "$cups of disposable cups\n" +
            "\$$money of money\n")
}

fun main () {
   while (true) {
       print("Write action (buy, fill, take, remaining, exit): ")
       when (scanner.next()) {
           "remaining" -> remaining()
           "buy" -> buy()
           "fill" -> fill()
           "take" -> take()
           "exit" -> exitProcess(2)
       }
   }
}