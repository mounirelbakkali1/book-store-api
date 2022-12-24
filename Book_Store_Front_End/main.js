$(document).ready(function () {
  //   $.ajax({
  //     contentType: "application/json",
  //     data: JSON.stringify({
  //       title: "book added using js",
  //       description:
  //         "Le lorem ipsum est, en imprimerie, une suite detion utralement, on u",
  //       imageURL: "images/imag.png",
  //       isbn: "",
  //       language: "FR",
  //       numberOfPages: 129,
  //       publicationDate: 1669849200000,
  //       unitCost: 99.98,
  //     }),
  //     dataType: "json",
  //     success: function (data) {
  //       console.log("request succeeded");
  //       console.log(data);
  //     },
  //     processData: false,
  //     type: "POST",
  //     url: "http://localhost:16162/building-rest-api-1.0-SNAPSHOT/api/books",
  //   });
  //   $.ajax({
  //     success: function (data) {
  //       console.log("request succeeded");
  //       console.log(data);
  //     },
  //     processData: false,
  //     type: "DELETE",
  //     url: "http://localhost:16162/building-rest-api-1.0-SNAPSHOT/api/books/26",
  //   });
  fetch("http://localhost:16162/building-rest-api-1.0-SNAPSHOT/api/books")
    .then((data) => data.json())
    .then((data) => {
      let output = "";
      data.forEach((book) => {
        output += `
		<div class="col-md-3">
          <div class="card h-100">
            <img src="${
              book.imageURL
            }" class="card-img-top" alt="Book 1" style="height:270px">
            <div class="card-body">
              <h5 class="card-title">${book.title}</h5>
              <p class="card-text">${book.description
                .split(/\s+/)
                .slice(0, 6)
                .join(" ")}</p>
              <p class="card-text">ISBN : ${book.isbn}</p>
              <p class="card-text">${book.unitCost} $</p>
              <a href="#" class="btn btn-warning w-100">Add to Cart</a>
            </div>
          </div>
        </div>
		`;
      });
      $(".row").html(output);
    });
});
