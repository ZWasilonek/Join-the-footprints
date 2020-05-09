// $("#deleteButton").click(function (event) {
//     if (window.confirm("Do you really want to delete?")) {
//         const excursionId = $(event.target).data('id');
//         window.location.href = `/app/excursion/delete?id=${excursionId}`;
//     }
// });
$(document).on('click', ".deleteButton", function(event){
    if (window.confirm("Do you really want to delete?")) {
        const excursionId = $(event.target).data('id'); // to powinno w sumie zadzialac dokladnie tak samo jak $(event.target).data('id');... ale sprawdz :)
        window.location.href = `/app/excursion/delete?id=${excursionId}`;
    }
});


$("#backButton").click(function () {
    window.location.href = `/app/excursion`;
});


$("#addButton").click(function () {
    window.location.href = `/app/excursion/add`;
});


$(document).on('click', ".editButton", function (event) {
    const excursionId = $(event.target).data('id');
    window.location.href = `/app/excursion/edit?id=${excursionId}`;
});


$("#searchButton").click(function() {
    window.location.href = `/app/excursion/find`;
});

$(document).on('click', ".showExcursionDetailsButton", function (event) {
    const excursionId = $(event.target).data('id');
    window.location.href = `/app/excursion/showDetails?id=${excursionId}`;
});

$(document).on('click', ".joinButton", function (event) {
    const excursionId = $(event.target).data('id');
    const userId = $(event.target).data('user_id');
    window.location.href = `/app/excursion/join?id=${excursionId}&user_id=${userId}`;
});


$(document).on('click', ".resignExcursionButton", function (event) {
    const excursionId = $(event.target).data('id');
    const userId = $(event.target).data('user_id');
    window.location.href = `/app/excursion/resign?id=${excursionId}&user_id=${userId}`;
});

$(document).on('click', ".saveUserButton", function (event) {
    const userId = $(event.target).data('id');
    window.location.href = `/app/user/edit?id=${userId}`;
});
