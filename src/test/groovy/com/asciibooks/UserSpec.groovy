package com.asciibooks

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<User> {

    def "password too short"() {
        when:
        domain.password = "short"

        then:
        !domain.validate(['password'])
        domain.errors['password'].code == "minSize.notmet"
    }
}