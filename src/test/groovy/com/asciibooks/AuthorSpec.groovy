package com.asciibooks

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification


class AuthorSpec extends Specification implements DomainUnitTest<Author> {


    void "DisplayName is correct"() {
        when:
        domain.name = name
        domain.penName = penName

        then:
        domain.displayName == displayName

        where:
        name    | penName  || displayName
        "Eric"  | "Author" || "Author"
        "Eric"  | null     || "Eric"
    }


    void "is active by default"() {
        given:
        def author = new Author()

        expect:
        author.active
    }

    void "Constraints: #name, #biography, #privateProfile isValid: #isValid"() {
        setup:
        def address = new Address()

        when:
        domain.name = name
        domain.biography = biography
        domain.privateProfile = privateProfile
        domain.address = address

        then:
        domain.validate() == isValid

        where:
        name    | biography | privateProfile | isValid
        null    | null      | null           | false
        "Eric"  | "Author"  | true           | true
        "Eric"  | "Author"  | false          | true
        "Eric"  | null      | false          | true
        null    | "Author"  | null           | false
    }





}
