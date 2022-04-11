document.addEventListener("DOMContentLoaded", async function () {
    const table = document.getElementById("dataUsers")
    const data = await getData()
    const title = document.getElementById("userTitle")
    let msg = table.innerHTML
    title.innerHTML = "Welcome administrator " + localStorage.email

    data.map((u, i) => {
        console.log(i, "---", u.name)
        let template = `<tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.email}</td>
                <td>${u.createdAt}</td>
                <td><div class="actions">
                    <button class="btn danger" onclick="deleteUser(${u.id})">Delete</button>
                    <button class="btn info" onclick="updateUser(${u.id})">Update</button>
                </div></td>
            </tr>`
        msg += template
    })
    table.innerHTML = msg
})

async function getData() {
    // http://localhost:8080/users/1003
    let users = await fetch("http://localhost:8080/api/users", {
        method: "GET",
        headers: {
            authorization: localStorage.token
        }
    })
    return users.json()
}

async function deleteUser(id) {
    if (!confirm("U sure?")) {
        return
    }
    await fetch("http://localhost:8080/api/users/" + id, {
        method: "DELETE",
        headers: {
            Authorization: localStorage.token
        }
    })
    location.reload()
}

function updateUser(id) {
    console.log("Updating:", id)
}