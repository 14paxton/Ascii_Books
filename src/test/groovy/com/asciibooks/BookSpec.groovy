package com.asciibooks

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class BookSpec extends Specification implements DomainUnitTest<Book> {

    void "Books are not published by default"() {
        expect:
        !domain.published
    }


    void "Reject invalid prices #price"() {
        when: "An invalid price is given"
        domain.price = price

        then: "Price field does not validate"
        !domain.validate(['price'])

        where:
        price << [-1, 1_000_01]
    }

    void "valid price #price"() {
        when: "An invalid price is given"
        domain.price = 9_99

        then: "Price field is valid"
        domain.validate(['price'])
    }


    void "Content can store #length chars"() {
        when: "Given a long string"
        domain.content = ("a" * length)

        then: "Content is valid"
        domain.validate(['content'])

        where:
        length << [256, 100_000]
    }


    void "Test Book.getFormattedPrice() Cents: #price Formatted: #formatted"() {
        given:
        domain.price = price

        expect:
        domain.formattedPrice == formatted

        where:
        price    | formatted
        1        | '$0.01'
        100      | '$1.00'
        110      | '$1.10'
        111      | '$1.11'
        1_000_00 | '$1,000.00'
    }





}
