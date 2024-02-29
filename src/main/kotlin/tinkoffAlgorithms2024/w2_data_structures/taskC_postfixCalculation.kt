package tinkoffAlgorithms2024.w2_data_structures

/*
#include <iostream>
#include <stack>
#include <string>

int get_answer(const std::string& expression) {
    std::stack<int> stack;
    std::string current_digit;

    for (auto symbol: expression) {
        if (isdigit(symbol)) {
            current_digit.push_back(symbol);
        } else if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {
            int second = stack.top();
            stack.pop();
            int first = stack.top();
            stack.pop();

            switch (symbol) {
                case '+':
                stack.push(first + second);
                break;
                case '-':
                stack.push(first - second);
                break;
                case '*':
                stack.push(first * second);
                break;
                default:
                stack.push(first / second);
                break;
            }
        } else if (symbol == ' ') {
            if (!current_digit.empty()) {
                stack.push(std::stoi(current_digit));
                current_digit.clear();
            }
        }
    }

    if (!current_digit.empty()) {
        stack.push(std::stoi(current_digit));
        current_digit.clear();
    }
    if (stack.empty()) {
        throw std::invalid_argument("Wrong expression, no digits in expressions.");
    }

    return stack.top();
}

int main() {
    std::string expression;

    std::getline(std::cin, expression);
    std::cout << get_answer(expression) << std::endl;

    return 0;
}
*/

fun main() {
    println("Unlucky")
}
