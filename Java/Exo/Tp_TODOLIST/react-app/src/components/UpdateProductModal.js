import React, { useState } from 'react';
import { jwtDecode } from "jwt-decode";

function UpdateTodoModal({ todo, onSave, onCancel }) {
  var accessTokenObj = JSON.parse(localStorage.getItem("user"));
  var token = accessTokenObj.data.token;
  var decoded = jwtDecode(token)
  const [title, setTitle] = useState(todo?.name);
  const [description, setDescription] = useState(todo?.price);
  const [done, setDone] = useState(todo?.done)

  const handleSubmit = (e) => {
    e.preventDefault();
    onSave({id:todo.id, title, description,done,user_id:decoded.user_id });
  };

  return (
    <div className="modal" style={{ display: 'block', backgroundColor: 'rgba(0,0,0,0.5)' }}>
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title">Update Todo</h5>
            <button type="button" className="close" onClick={onCancel}>
              <span>&times;</span>
            </button>
          </div>
          <div className="modal-body">
            <form onSubmit={handleSubmit}>
              <div className="form-group">
                <label>Name</label>
                <input type="text" className="form-control" value={title} onChange={(e) => setTitle(e.target.value)} />
              </div>
              <div className="form-group">
                <label>Price</label>
                <input type="text" className="form-control" value={description} onChange={(e) => setDescription(e.target.value)} />
              </div>
              <div className="form-group">
                <label>Completed</label>
                <input type="checkbox" className="form-control" value={done} onChange={(e) => setDone(!done)} />
              </div>
              <button type="submit" className="btn btn-primary">Save changes</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default UpdateTodoModal;