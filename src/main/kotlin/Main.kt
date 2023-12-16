import kotlin.system.exitProcess

fun main() {
    // Инициализация объектов пиццерий для разных городов
    val pizzaPeter = PizzaPeter(
        175.0, 241.5,
        167.5, 215.0
    )
    val pizzaMoscow = PizzaMoscow(
        215.0, 250.5,
        180.5, 240.0
    )
    val pizzaYaroslavl = PizzaYaroslavl(
        210.0, 240.5,
        170.5, 230.0
    )

    // Переменная для текущей выбранной пиццерии
    var currentPizzaCity: PizzaCity

    // Основной цикл программы
    while (true) {
        // Вывод меню выбора города
        println("Добрый день! Выберите город")
        println("1. Москва\n2. Санкт-Петербург\n3. Ярославль\n0. Выход из программы")

        // Обработка выбора города
        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaYaroslavl
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }

        // Вывод меню выбора пиццы
        println("\nВыберите пиццу:")
        println(
            "1. Неаполитанская пицца\n" +
                    "2. Римская пицца\n" +
                    "3. Сицилийская пицца\n" +
                    "4. Тирольская пицца\n" +
                    "0. Показать статистику"
        )
        // Обработка выбора пиццы
        selectPizza(currentPizzaCity)
    }
}

// Функция для выбора пиццы и вызова соответствующих действий
private fun selectPizza(currentPizzaCity: PizzaCity) {
    // Обработка выбора пользователя
    when (readln()) {
        "1" -> {
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity, "neapolitanPizza")
        }

        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity, "romanPizza")
        }

        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity, "sicilianPizza")
        }

        "4" -> {
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity, "tyroleanPizza")
        }

        "0" -> currentPizzaCity.showStatistics()
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }
}

// Функция для выбора дополнительных услуг пиццерии
fun selectAddService(currentPizzaCity: PizzaCity, currentPizza: String) {
    // Обработка выбора дополнительных услуг
    when {
        currentPizzaCity is Drink && currentPizzaCity is CheckPhoto && currentPizzaCity is SauceSelector -> {
            currentPizzaCity.drinkSale(currentPizza)
            currentPizzaCity.showCheckPhoto()
            currentPizzaCity.selectSauce()
        }

        currentPizzaCity is CheckPhoto -> currentPizzaCity.showCheckPhoto()
        currentPizzaCity is Drink -> currentPizzaCity.drinkSale(currentPizza)
    }
}