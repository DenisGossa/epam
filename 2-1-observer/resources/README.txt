Структура построения объектов классов в виде цепочки 
входные данные -класс - выходные данные

file -> class FileReader -> List<String> loadedDataList

List<String>loadedDataList ->class FileDataValidation -> List<String> validatedList

List<String>validatedList -> class FigureDataParser -> List<Integer>objectParameters

List<Integer>objectParameters -> class PyramidCreator -> Pyramid

Pyramid -> to Warehouse
Pyramid -> to repositopry

// log4j не подключался - какая-то проблема с библиотеками в скачанных jar
// тесты сделаны частично