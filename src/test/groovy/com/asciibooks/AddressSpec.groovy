package com.asciibooks

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AddressSpec extends Specification implements DomainUnitTest<Address> {

    void "toString() does not contain the string null"() {
        expect: "The toString to not contain the word null"
        ! domain.toString().contains("null")
    }
}
