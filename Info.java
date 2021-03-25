public class Info {
    public static void main(String[] args) {
        InfoBook book = new InfoBook();

        book.add("Бурунов", "84456784453");
        book.add("Петров", "8918171326");
        book.add("Федоров", "8925105552");
        book.add("Ургант", "8912455672");
        book.add("Нагиев", "849588777");
        book.add("Хабенский", "896211111");
        book.add("Бондарчук", "89163231999");
        book.add("Бурунов", "8499763113");
        book.add("Аксенова", "8324325234");

        System.out.println(book.get("Нагиев"));
        System.out.println(book.get("Ургант"));
        System.out.println(book.get("Бурунов"));
        System.out.println(book.get("Аксенова"));
    }
}

