Collectors.toList() Liste aller Elemente des Streams
Collectors.summingInt(Employee::getSalary) Summe aller Salaries
Collectors.averagingInt(Employee::getSalary) Durchschnitt aller Salaries
Collectors.joining(", ") Verketten der Strings des Streams
Collectors.groupingBy(Employee::getDepartment) Map mit Department als Key und
Employees als Value

