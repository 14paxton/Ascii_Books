package asciibooks

import grails.util.Environment
import com.asciibooks.*

class BootStrap {

    def init = { servletContext ->
        if(Environment.current == Environment.DEVELOPMENT) {
            createDevUsers()
            createDevData()
        }
    }

    def createDevData() {
        def address = new Address().save(failOnError:true)
        def eric = new Author(name: "Eric Helgeson", biography: "Grails Developer & Writer", address: address).save(failOnError:true)
        def grails3Book = new Book(author: eric, title: "Practical Grails 3", price: 100).save(failOnError:true)
        def boot1Book = new Book(author: eric, title: "Practical Spring Boot", price: 200).save(failOnError:true)
    }

    def createDevUsers() {
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(failOnError:true)
        def authorRole = new Role(authority: 'ROLE_AUTHOR').save(failOnError:true)

        def admin = new User(email: "admin@email.com", password: 'password').save(failOnError:true)
        def author = new User(email: "author@email.com", password: 'password').save(failOnError:true)

        UserRole.create(admin, adminRole)
        UserRole.create(author, authorRole)
    }

    def destroy = { }
}
