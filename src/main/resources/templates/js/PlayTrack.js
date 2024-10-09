const playButtons = document.querySelectorAll('.play-button');

playButtons.forEach(button => {
    button.addEventListener('click', () => {
        alert('Воспроизведение трека...');
    });
});
