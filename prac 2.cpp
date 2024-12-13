#include <iostream> 
using namespace std; 
 
class Calculator { 
public: 
    float add(double a, double b) { 
        return a + b; 
    } 
 
    float subtract(double a, double b) { 
        return a - b; 
    } 
 
    float multiply(double a, double b) { 
        return a * b; 
    } 
 
    float divide(double a, double b) { 
        if (b == 0) { 
            cout << "Error: Division by zero." <<endl; 
            return 0; 
        } 
        return a / b; 
    } 
}; 
 
int main() { 
    Calculator calc; 
    char choice; 
    do { 
        float num1, num2, result; 
        char op; 
 
        cout << "Enter first number: "; 
        cin >> num1; 
        cout << "Enter second number: "; 
        cin >> num2; 
        cout << "Enter an operator (+, -, *, /): "; 
        cin >> op; 
 
        switch (op) { 
            case '+': 
                result = calc.add(num1, num2); 
                break; 
            case '-': 
                result = calc.subtract(num1, num2); 
                break; 
            case '*': 
                result = calc.multiply(num1, num2); 
                break; 
            case '/': 
                result = calc.divide(num1, num2); 
                break; 
            default: 
                cout << "Error: Invalid operator." << endl; 
                continue;  
        } 
 
        cout<< "Result: " << result <<endl; 
 
        cout<< "Do you want to perform another calculation? (y/n): "; 
        cin >> choice; 
 
    } while (choice == 'y' || choice == 'Y'); 
 
    cout << "Thank you for using the calculator!" <<endl; 
 
    return 0; 
}