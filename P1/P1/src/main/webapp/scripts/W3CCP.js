window.onload = function() {
    document.getElementById("poke").onclick = function() {
        sendAjaxGet('https://pokeapi.co/api/v2/pokemon/ditto/', findPokemon);
    };
}

// perform Ajax call
// url represents the resource being requested
// func represents the callback function to be invoked when request is complete
function sendAjaxGet(url, func) {
    // step 1: obtain xhr object (Internet Explorer 5,6 don't have it...)
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    // step 2: define onreadystatechange
    xhr.onreadystatechange = function() {
        // readyState of 4 means request is complete
        // status of 200 means ok
        if (this.readyState == 4 && this.status == 200) {
            func(this);
        }
    }
    // step 3: prepare the request
    xhr.open("GET", url, true);
    // step 4: send the request
    xhr.send(); 
    // IF WE WERE SENDING A POST REQUEST OR ANYTHING THAT USED THE BODY
    // IT WOULD GO AS AN ARGUMENT TO SEND()
}

function findPokemon(xhr) {
    let pokeObj = JSON.parse(xhr.responseText);
    console.log(pokeObj);
    document.getElementById("Pokemon").innerText = "Ditto!" + pokeObj;
}

window.onload = function() {
    
    document.getElementById("addBook").addEventListener("click", function() {
        let bookName = document.getElementById("bookName").value;
        let author = document.getElementById("author").value;
        let genre = document.getElementById("genre").value;
        let coverImage = document.getElementById("coverImage").value;
        //alert("You've Added a New Book!");
        console.log(bookName + " " + author + " " + genre + " " + coverImage);
        Book(bookName, author, genre, coverImage);
    });

    //let bookShelf = [{title:"Warriors", author:"Erin Hunter", genre:"Fantasy Fiction", coverImage:"Picture"},
                        //{title:"The Reckoning", author:"John Grisham", genre:"Horror", coverImage:"Pciture"}];

    //document.getElementById("name").innerHTML = bookShelf[0].title;
    //document.getElementById("author1").innerHTML = bookShelf[0].author;
    //document.getElementById("genre1").innerHTML = bookShelf[0].genre;
    //document.getElementById("coverImage1").innerHTML = bookShelf[0].coverImage;
//}

function Book(bookName, author, genre, coverImage) {
    var books = {bookName, author, genre, coverImage};
    console.log(books);
    var x = books.toString();
    //document.getElementById("showBook").innerHTML = "Current Books: " + x;
    //document.getElementById("showBook").innerText = "Current Books: " + books;
    
    //books.add(bookName, author, genre, coverImage);
    
    document.getElementById("name").innerText = "Book Name: " + books.bookName;
    document.getElementById("author1").innerText = "Author: " + books.author;
    document.getElementById("genre1").innerText = "Genre: " + books.genre;
    document.getElementById("coverImage1").innerText = "Book Image: " + books.coverImage;
}

//function showBooks(){
    //document.getElementById("")
    //var x = books.toString();
    //document.getElementById("showBook").innerText = "Current Books: " + x;
//}

//window.onload = function(){

   // document.getElementById("showBook").addEventListener("click", function(){
     //   console.log(books);
   // });
}
