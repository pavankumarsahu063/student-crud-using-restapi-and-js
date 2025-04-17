const form=document.getElementById("form");

form.addEventListener("submit", async (e)=>{
    e.preventDefault();

    const student={
        name:document.getElementById("name").value,
        email:document.getElementById("email").value,
        course:document.getElementById("course").value,
        password:document.getElementById("password").value
    }

    console.log(student)
    const response=await fetch("http://localhost:8080/api/addstudent",{
            method:"POST",
            headers: { "Content-Type": "application/json" },
            body:JSON.stringify(student)


     });


     if(response.ok){
        document.querySelector(".message").textContent="Submited Sucessfully"
     }
})

const getData=async ()=>{
    const response=await fetch("http://localhost:8080/api/getStudents");
    const data=await response.json();

    return data;
}

const displayContainer=document.querySelector(".display-Stuudents");
addEventListener("DOMContentLoaded",async ()=>{

   const data=await getData();

    console.log(data)
    const div=document.createElement("div");
    div.className="card"

    data.forEach(data=>{
        console.log(data)

        div.innerHTML+=`
            <h3>Name: ${data.name}</h3>
            <h4>${data.email}</h4>
            <h4>${data.course}</h4>
           
            <button class="delete">Delete</button>
        `;

        div.querySelector(".delete").addEventListener("click",async (e)=>{

                const response=await fetch(`http://localhost:8080/api/delete/${data.id}`,{
                    method:"DELETE"
                });


                if(response.ok){
                     document.querySelector(".message").textContent="Deleted Sucessfully"
                }
        })

    })
    displayContainer.append(div)
})
