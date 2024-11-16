import kotlin.system.exitProcess

fun main() {
    val pizzaPeter = PizzaPeter(
        neapolitanPizzaPrice = 175.0, romanPizzaPrice = 241.5,
        sicilianPizzaPrice = 167.5, tyroleanPizzaPrice = 215.0
    )
    val pizzaMoscow = PizzaMoscow(
        neapolitanPizzaPrice = 215.0, romanPizzaPrice = 250.5,
        sicilianPizzaPrice = 180.5, tyroleanPizzaPrice = 240.0
    )
    val pizzaVilga = PizzaVilga(
        neapolitanPizzaPrice = 100.0, romanPizzaPrice = 150.5,
        sicilianPizzaPrice = 120.5, tyroleanPizzaPrice = 140.0
    )
    var currentPizzaCity: PizzaCity

    while(true) {
        println("| Добрый день! Выберите город")
        println("  1. Москва\n  2. Санкт-Петербург\n  3. Вилга\n! 0. Выход из программы")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaVilga
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }
        println("| Выберите пиццу:")
        println("  1. Неаполитанская пицца\n  2. Римская пицца\n  3. Сицилийская пицца\n" +
                "  4. Тирольская пицца\n! 0. Показать статистику")
        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    when (readln()) {
        "1" -> {
            selectAddService(currentPizzaCity)
            currentPizzaCity.neapolitanPizzaSale()
        }
        "2" -> {
            selectAddService(currentPizzaCity)
            currentPizzaCity.romanPizzaSale()
        }
        "3" -> {
            selectAddService(currentPizzaCity)
            currentPizzaCity.sicilianPizzaSale()
        }
        "4" -> {
            selectAddService(currentPizzaCity)
            currentPizzaCity.tyroleanPizzaSale()
        }
        "0" -> currentPizzaCity.showStatistics()
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }
}

fun selectAddService(currentPizzaCity: PizzaCity) {
    if (currentPizzaCity is PizzaVilga) {
        currentPizzaCity.showCheckPhoto()
        currentPizzaCity.drinkSale()
        currentPizzaCity.sauseSale()
    } else {
        when (currentPizzaCity) {
            is CheckPhoto -> currentPizzaCity.showCheckPhoto()
            is Drink -> currentPizzaCity.drinkSale()
            is Sause -> currentPizzaCity.sauseSale()
        }
    }
}