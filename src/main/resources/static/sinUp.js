document.addEventListener('DOMContentLoaded', function () {
    const name = document.getElementById('txtName');
    const email = document.getElementById('txtEmail')
    const password = document.getElementById('txtPassword')
    const passwordConfirm = document.getElementById('txtPasswordConfirm')
    const form = document.getElementById('formSingIn')
    form.addEventListener('submit', (e) => {
        e.preventDefault()
        if (password.value === passwordConfirm.value) {
            registerUser(name.value, email.value, password.value).then(()=>window.location="index.html")
        } else {
            console.log("passwords do not match")
        }
    })
})

async function registerUser(name, email, password) {
    await fetch("http://localhost:8080/api/users", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({name, email, password})
    })
}

function returnStrong(name, email, password) {
    console.log(JSON.stringify({name, email, password}))
}