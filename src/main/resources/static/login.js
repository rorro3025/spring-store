document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById("singInForm")
    form.addEventListener('submit', (e) => {
        e.preventDefault();
        let email = form['txtEmail'].value
        let password = form['txtPassword'].value
        console.log(email, ":", password)
        handleSubmit(email, password).then((res) => {
            if (res !== "error") {
                localStorage.token = res
                localStorage.email = email
                window.location = "index.html"
            } else {
                setMessage()
            }
        })
    })
})

const handleSubmit = async (email, password) => {
    //"http://localhost:8080/api/users
    let res = await fetch("http://localhost:8080/api/login", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({email, password})
    })
    return res.text()
}

const setMessage = () => {
    const container = document.querySelector("#message")
    container.innerHTML = '<div class="message"><h3>Error: </h3><p>please check your username and password</p></div>'
}