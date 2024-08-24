#include <vector>
#include <string>
#include <iostream>

class Product1 {
    public:
    std::vector<std::string> parts_;
    void ListParts() const {
        std::cout << "Product parts: ";
        for (size_t i = 0; i < parts_.size(); i++) {
            if (parts_[i] == parts_.back()) {
                std::cout << parts_[i];
            } else {
                std::cout << parts_[i] << ", ";
            }
        }
        std::cout << "\n\n";
    }
};

/**
 * The Builder interface specifies methods for creating the different parts of
 * the Product objects.
 */

class Builder {
    public:
    virtual ~Builder() {};
    virtual void ProductPartA() const = 0;
    virtual void ProductPartB() const = 0;
    virtual void ProductPartC() const = 0;
};

