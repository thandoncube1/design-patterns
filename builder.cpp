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
    virtual void ProducePartA() const = 0;
    virtual void ProducePartB() const = 0;
    virtual void ProducePartC() const = 0;
};

/**
 * The concrete Builder classes follow the Builder interface and provide
 * specific implementations of the building steps. Your program may have several
 * variations of Builders, implemented differently
 */

class ConcreteBuilder1: public Builder {
    private:

    Product1* product;

    /**
     * A fresh builder instance should contain a blank product object, which
     * is used in further assembly.
     */

    public:

    ConcreteBuilder1() {
        this->Reset();
    }

    ~ConcreteBuilder1() {
        delete product;
    }

    void Reset() {
        this->product = new Product1();
    }

    /**
     * All production steps work with the same product instance.
     */

    void ProducePartA() const override {
        this->product->parts_.push_back("PartA1");
    }

    void ProducePartB() const override {
        this->product->parts_.push_back("PartB1");
    }

    void ProducePartC() const override {
        this->product->parts_.push_back("PartC1");
    }

    /**
     * Concrete Builders are supposed to provide their own methods for retrieving results. That's because various types of builders may create entirely different products that don't follow the same interface.
     * Therefore, such methods cannot be declared in the base Builder interface
     * (atleast in a statically typed programming language).
     * 
     * Usually after returning the end result to the client, a builder instance is expected to be ready to start producing another product. That's why it's usual practice to call the reset method at the end of the `getProduct` method body.
     */
    // Be careful with memory ownership. Once you call GetProduct the user of this function is responsible to release this memory from the Heap. Here could be a better option to use smart pointers to avoid memory leaks.

    Product1* GetProduct() {
        Product1* result = this->product;
        this->Reset();
        return result;
    }
};

/**
 * The Director is only responsible for executing the building steps in a 
 * particular sequence. It is helpful when producing products according to a 
 * specific order or configuration. Strictly speaking, the Director class is optional, since the client can control builders directly.
 */

class Director {
    /**
     * @var Builder
     */
    private:
    Builder* builder;
    /**
     * The Director works with any builder instance that the client code passes
     * to it. This way, the client code may alter the final type of the newly assembled product.
     */
    public:

    void set_builder(Builder* builder) {
        this->builder = builder;
    }

    /**
     * The Director can construct several product variations using the same
     * building steps.
     */

    void BuilMinimalViableProduct() {
        this->builder->ProducePartA();
    }

    void BuildFullFeaturedProduct() {
        this->builder->ProducePartA();
        this->builder->ProducePartB();
        this->builder->ProducePartC();
    }
};

