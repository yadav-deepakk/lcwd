import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router';
import { BASE_URL_STUDENT_V1 } from '../constants/constants';

const StudentList = () => {

  const navigate = useNavigate();

  const [studentList, setStudentList] = useState([]);

  useEffect(() => {
    fetch(BASE_URL_STUDENT_V1)
      .then(response => response.json())
      .then(data => {
        console.log("Fetched student data:", data);
        setStudentList(data); 
      })
      .catch((error) => console.error("Error fetching student data:", error));
  }, []);

  return (
    <>
      <div>
        <h3>
          Students List ({studentList.length}) 
          <button onClick={() => navigate("/add-student")}>Add Student</button> 
        </h3>
        <hr />
          { studentList.map(( student) => (
            <div key={student['studentId']}>
              <span>{student['name']}</span><br />
              <span>{student['email']}</span><br />
              <span>{student['username']}</span><br />
              <button onClick={() => navigate(`/view-student/${student['studentId']}`)}>View Details</button>
              <hr />
            </div>
          ))}
      </div>
    </>
  )
}

export default StudentList